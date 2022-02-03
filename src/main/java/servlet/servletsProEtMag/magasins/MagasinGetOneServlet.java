package servlet.servletsProEtMag.magasins;

import servlet.models.Magasin;
import servlet.service.MagasinService;
import servlet.service.MagasinServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MagasinGetOneServlet", value = "/onemag")
public class MagasinGetOneServlet extends HttpServlet {

    private final MagasinService magasinService = MagasinServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        PrintWriter out = response.getWriter();

        try{
            int id = Integer.parseInt(request.getParameter("id"));
            Magasin m = magasinService.getOne(id);

            if (m == null){
                response.setStatus(400);
                out.print("Veuillez encoder un id.");
            } else{
                out.println(m.toString()); ;
            }

        }catch (NumberFormatException ex){
            response.setStatus(400);
            out.print("Votre id n'est pas valide.");
        }
        out.close();

    }
}
