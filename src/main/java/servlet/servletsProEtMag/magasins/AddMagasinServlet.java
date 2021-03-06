package servlet.servletsProEtMag.magasins;

import servlet.models.Magasin;
import servlet.service.MagasinService;
import servlet.service.MagasinServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddMagasinServlet", value = "/addmag")
public class AddMagasinServlet extends HttpServlet {

    private final MagasinService magasinService = MagasinServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try{
            int id = Integer.parseInt(request.getParameter("id"));
            String nom = request.getParameter("nom");
            String rue = request.getParameter("rue");
            String ville = request.getParameter("ville");
            int codePostal = Integer.parseInt(request.getParameter("cp"));
            int numero = Integer.parseInt(request.getParameter("numero"));
            double superficie = Double.parseDouble(request.getParameter("superficie"));

            if (nom == null || nom.isBlank() || rue == null || rue.isBlank() || ville == null || ville.isBlank()){
                response.setStatus(400);
                out.print("Le nom, la rue ou la ville ne sont pas définis.");
            } else {
                Magasin m = new Magasin(id, nom, rue, ville, codePostal, numero, superficie);

                if (magasinService.insert(m)){
                    response.sendRedirect(request.getContextPath()+"/magall");
                } else{
                    response.setStatus(400);
                    out.print("Cet id est déjà pris");
                }
            }
        } catch (NumberFormatException ex){
            response.setStatus(400);
            out.print("Votre id, votre code postal ou votre numéro ne sont pas valides.");
        }
        out.close();


    }
}
