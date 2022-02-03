package servlet.servletsProEtMag.produits;

import streams.exo.ProduitService;
import streams.exo.ProduitServiceImpl;
import streams.exo.models.ProduitForm;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet", value = "/modifie")
public class ModifieServlet extends HttpServlet {

    private final ProduitService service = ProduitServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\"\n" +
                "          content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
                "    <title>Add produit</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "    <form action=\""+request.getContextPath()+"/modifie\" method=\"post\">\n" +
                "        <input type=\"number\" name=\"id\" placeholder=\"id\"><br>\n" +
                "        <input type=\"text\" name=\"nom\" placeholder=\"nom\"><br>\n" +
                "        <input type=\"number\" name=\"prix\" placeholder=\"prix\"><br>\n" +
                "        <button type=\"submit\">modifier</button>\n" +
                "    </form>\n" +
                "\n" +
                "</body>\n" +
                "</html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();


        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nom = request.getParameter("nom");
            double prix = Double.parseDouble(request.getParameter("prix"));

            if (nom == null || nom.isBlank()){
                response.setStatus(400);
                out.print("Votre nom n'est pas défini.");
            } else if(service.getOne(id) == null){
                response.setStatus(400);
                out.print("Votre id ne fait pas partie de la liste.");
            } else{
                ProduitForm form = new ProduitForm(nom, prix);
                service.update(id, form);
                out.print("Produit modifié !");
                response.sendRedirect(request.getContextPath()+"/produit");
            }

        } catch (NumberFormatException ex){
            response.setStatus(400);
            out.print("Id ou prix invalide(s).");
        }

    }
}