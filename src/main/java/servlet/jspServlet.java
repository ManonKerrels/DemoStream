package servlet;

import java.io.PrintWriter;
// Traduction en java du JSP
// du texte html :

class jspServlet {

//    void service(request, response){
//        PrintWriter out = ...;
//        out.print("...html...");
//    }
}

// la directive d'expression :
//<%= 1+1 %>

//class JspServlet{
//
//    void service(request, response){
//        PrintWriter out = response.getWriter();
//        out.print(1+1);
//    }
//}

// directive de scriptlet
//<%
//        for(int i = 0; i<5; i++){
//        out.println("Hey")
//        }
//        %>

//class JspServlet{
//
//    void service(request, response){
//        PrintWriter out = ...;
//        for(int i = 0; i<5; i++){
//            out.println("Hey");
//            out.println(i);
//        }
//    }
//}

// directive de déclaration
// <%! int a = 5; %>

//on écrit en dehors du service, pour définir des méthodes et des variables

//