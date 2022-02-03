package servlet.servletsProEtMag.magasins;

import servlet.models.Magasin;
import servlet.service.MagasinService;
import servlet.service.MagasinServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "MagasinGetAllServlet", value = "/magall")
public class MagasinGetAllServlet extends HttpServlet {

    private final MagasinService magasinService = MagasinServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Magasin> list = magasinService.getAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("./jsp/magasin/all_magasin.jsp").forward(request, response);

    }
}
