package servlet.servletsProEtMag.magasins;

import servlet.service.MagasinService;
import servlet.service.MagasinServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteMagasinServlet", value = "/deletemag")
public class DeleteMagasinServlet extends HttpServlet {

    private final MagasinService magasinService = MagasinServiceImpl.getInstance();

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try{
            int id = Integer.parseInt(request.getParameter("id"));

            if (magasinService.getOne(id) == null){
                response.setStatus(400);
                out.print("Veuillez encoder un id.");
            } else{
                magasinService.delete(id);
                response.sendRedirect(request.getContextPath()+"/magall");
            }

        } catch (NumberFormatException ex){
            response.setStatus(400);
            out.print("Votre id n'est pas valide.");
        }


    }
}
