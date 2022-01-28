package streams.exo;

import streams.exo.models.Produit;
import streams.exo.models.ProduitForm;

import java.util.Comparator;
import java.util.List;

public interface ProduitService {

    List<Produit> getAll();
    Produit getOne(int id);

    boolean insert(Produit toAdd);

    Produit delete(int id);

    void update(int id, ProduitForm form);

    List<Produit> getAllSorted(Comparator<Produit> comparator);
    Produit getCheapest();
    Produit getMostExpensive();

    List<Produit> getAllByBrand(String brand);

}
