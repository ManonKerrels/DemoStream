package servlet;

import streams.exo.ProduitService;
import streams.exo.ProduitServiceImpl;
import streams.exo.models.Produit;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ProduitGetAllBisServlet extends HttpServlet {

    private final ProduitService service = ProduitServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        List<Produit> list = service.getAll();
        request.setAttribute("list", list);
        request.getAttribute("/jsp/produit/all_produit.jsp");
    }
}
