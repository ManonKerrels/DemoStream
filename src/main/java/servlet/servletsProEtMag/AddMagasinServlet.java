package servlet.servletsProEtMag;

import servlet.service.MagasinService;
import servlet.service.MagasinServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddMagasinServlet", value = "/")
public class AddMagasinServlet extends HttpServlet {

    private final MagasinService service = MagasinServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PrintWriter out = response.getWriter();
//
//        try{
//
//
//
//        } catch (NumberFormatException ex){
//            response.setStatus(400);
//            out.print("Votre id n'est pas valide.");
//        }


    }
}
