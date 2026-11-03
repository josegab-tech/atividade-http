#  Atividade Prática — Servlets & Protocolo HTTP em Java

Este projeto foi desenvolvido como atividade prática para estudo aprofundado do protocolo HTTP e da arquitetura de **Servlets em Java (Jakarta EE)** executados no **Apache Tomcat 10**.

O objetivo principal foi compreender o ciclo de vida das requisições web, manipulação de cabeçalhos, leitura de dados brutos (*raw body*), gestão de estado (Sessões e Cookies), códigos de status HTTP e interceptação através de Filtros, sem a utilização de frameworks de alto nível.

---

##  Tecnologias Utilizadas

* **Linguagem:** Java 21
* **API Web:** Jakarta Servlet 6.0 (`jakarta.servlet.*`)
* **Servidor de Aplicação:** Apache Tomcat 10.1.x
* **IDE:** Eclipse IDE for Enterprise Java and Web Developers
* **Gerenciador de Build:** Dynamic Web Project (Estrutura nativa Jakarta EE)

---

##  Estrutura dos Servlets e Endpoints

| Endpoint | Classe / Filtro | Descrição / Protocolo HTTP |
| :--- | :--- | :--- |
| `/headers` | `HeaderServlet.java` | Processa requisições `GET` e inspeciona os cabeçalhos enviadas pelo cliente (`User-Agent`, `Accept-Language`, IP do cliente, etc.). |
| `/request-body` | `RequestBodyServlet.java` | Processa formulários `POST`, comparando a extração via `request.getParameter()` com a leitura do *Raw Body* via `BufferedReader`. |
| `/session-cookie` | `SessionCookieServlet.java` | Demonstra a gestão de estado sobre o protocolo *stateless*, utilizando `HttpSession` (`JSESSIONID`) e `Cookie` personalizado com tempo de vida (`Max-Age`). |
| `/status-redirect` | `StatusRedirectServlet.java` | Manipula respostas HTTP com códigos de status (`200 OK`, `400 Bad Request`, `401 Unauthorized`) e redirecionamentos pelo cliente (`302 Found`). |
| `/*` | `LoggingFilter.java` | Intercepta todas as requisições do pipeline, registando logs de entrada/saída e medindo o tempo de resposta em milissegundos. |

---

##  Como Executar o Projeto

### Pré-requisitos
* **Java Development Kit (JDK 21)** instalado.
* **Apache Tomcat 10.1.x** configurado no seu ambiente.
* **Eclipse IDE for Enterprise Java and Web Developers**.

### Passo a Passo
1. Clone este repositório para a sua máquina local:
   ```bash
   git clone https://github.com/josegab-tech/atividade-http.git
