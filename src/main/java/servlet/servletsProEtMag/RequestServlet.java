package servlet.servletsProEtMag;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "RequestServlet", value = "/request")
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String protocol = request.getProtocol();

        Map<String, String> headers = new HashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()) { //cela fournit une map des headers
            String header = headerNames.nextElement();
            headers.put(header, request.getHeader(header));
        }

        String body = request.getReader()
                .lines()
                .reduce("", (acc, line) -> acc + line); //accumulation qui a pour valeur de base "", à laquelle on rajoute une ligne après l'autre

        out.print(method);
        out.print(' ');
        out.print(uri);
        out.print(' ');
        out.println(protocol);

        headers.forEach((key, value) -> out.println(key + ":" + value));
        out.println();
        out.print(body);

        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
