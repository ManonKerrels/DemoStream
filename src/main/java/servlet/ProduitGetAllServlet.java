package servlet;

import streams.exo.models.Produit;
import streams.exo.ProduitService;
import streams.exo.ProduitServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ProduitGetAllServlet", value = "/produit")
public class ProduitGetAllServlet extends HttpServlet {

    private final ProduitService service = ProduitServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");

        List<Produit> list = service.getAll();
        PrintWriter out = response.getWriter();

        out.print(
                """
                        <!doctype html>
                        <html lang="en">
                        <head>
                            <meta charset="UTF-8">
                            <meta name="viewport"
                                  content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
                            <meta http-equiv="X-UA-Compatible" content="ie=edge">
                            <title>GetAll produit</title>
                        </head>
                        <body>
                                                
                            <h1>Liste de produits</h1>
                                                
                            <ul>
                            """);

        list.forEach(produit -> {
            out.print("<li>");
            out.print(produit.getNom());
            out.print(' ');
            out.print(produit.getMarque());
            out.print(' ');
            out.print(produit.getPrix());
            out.print("$</li>");
        }
        );

        out.print("</ul>\n" +
                        "  \n" +
                        "  </body>\n" +
                        "  </html>"
        );

    }

}