package br.edu.ifsuldeminas;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/headers")
public class HeaderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Análise de Cabeçalhos</title></head><body>");
        out.println("<h2>Cabeçalhos Recebidos na Requisição HTTP</h2>");
        out.println("<ul>");

        // Percorre todos os nomes de cabeçalhos enviados pelo cliente/navegador
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            out.println("<li><b>" + headerName + ":</b> " + headerValue + "</li>");
        }

        out.println("</ul>");
        out.println("<hr>");
        
        // Exibe o IP do cliente e o protocolo HTTP utilizado
        out.println("<p><b>IP do Cliente:</b> " + request.getRemoteAddr() + "</p>");
        out.println("<p><b>Protocolo:</b> " + request.getProtocol() + "</p>");

        out.println("</body></html>");
    }
}