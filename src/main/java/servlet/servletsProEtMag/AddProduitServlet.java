package servlet.servletsProEtMag;

import streams.exo.models.Produit;
import streams.exo.ProduitService;
import streams.exo.ProduitServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddProduitServlet", value = "/ajout")
public class AddProduitServlet extends HttpServlet {

    private final ProduitService service = ProduitServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                "    <form action=\""+request.getContextPath()+"/ajout\" method=\"post\">\n" +
                "        <input type=\"text\" name=\"id\" placeholder=\"id\"><br>\n" +
                "        <input type=\"text\" name=\"nom\" placeholder=\"nom\"><br>\n" +
                "        <input type=\"text\" name=\"marque\" placeholder=\"marque\"><br>\n" +
                "        <input type=\"number\" name=\"prix\" placeholder=\"prix\"><br>\n" +
                "        <button type=\"submit\">envoyer</button>\n" +
                "    </form>\n" +
                "\n" +
                "</body>\n" +
                "</html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try{
            int id = Integer.parseInt(request.getParameter("id"));
            String nom = request.getParameter("nom");
            String marque = request.getParameter("marque");
            double prix = Double.parseDouble(request.getParameter("prix"));

            if (nom == null || nom.isBlank() || marque == null || marque.isBlank()){
                response.setStatus(400);
                out.print("Votre marque ou votre nom ne sont pas définis.");
            } else {
                Produit p = new Produit(id, nom, marque, prix);
                if (service.insert(p)){
//                    response.setStatus(300); //ligne pas nécessaire (juste parce qu'on l'a fait partout ailleurs)
                    out.print(p +"\t\tajouté !");
                    response.sendRedirect(request.getContextPath()+"/produit");
//                    idem que ce qu'il y a au-dessus
//                    request.getRequestDispatcher(request.getContextPath()+"/produit")
//                            .forward(request, response);
                } else {
                    response.setStatus(400);
                    out.print("Cet id est déjà pris");
                }
            }
        } catch (NumberFormatException ex){
            response.setStatus(400);
            out.print("Votre id ou votre prix ne sont pas valides.");
        }


    }
}
