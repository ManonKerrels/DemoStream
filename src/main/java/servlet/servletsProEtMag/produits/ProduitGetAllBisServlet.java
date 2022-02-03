package servlet.servletsProEtMag.produits;

import streams.exo.ProduitService;
import streams.exo.ProduitServiceImpl;
import streams.exo.models.Produit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@WebServlet(name = "ProduitGetAllServlet", value = "/produit")
public class ProduitGetAllBisServlet extends HttpServlet {

    private final ProduitService service = ProduitServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Produit> list = service.getAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/jsp/produit/all_produit.jsp").forward(request, response);
    }
}
