package streams.exo;

import streams.exo.exceptions.NoProduitException;
import streams.exo.exceptions.ProduitNotFoundException;
import streams.exo.models.Produit;
import streams.exo.models.ProduitForm;

import java.util.*;

public class ProduitServiceImpl implements ProduitService{

    List<Produit> liste = new ArrayList<>();
    private static ProduitServiceImpl _instance;

    public static ProduitServiceImpl getInstance(){
        if (_instance == null){
            _instance = new ProduitServiceImpl();
        }
        return _instance;
        //return _instance == null ? _instance = new ProduitServiceImpl(): _instance; //idem que le bloc if juste avant
    }

    public ProduitServiceImpl(){
        liste.add(new Produit(1, "Cigarettes", "tmtc", 1.5));
        liste.add(new Produit(2, "Café", "La Caféière", 7));
        liste.add(new Produit(3, "Chocolat", "CoteD'Or", 5));
    }

    @Override
    public List<Produit> getAll() {
        return new ArrayList<>(liste); //soit ça, soit retourner juste la liste
        //return List.copyOf(liste); -> autre manière de le faire
    }

    @Override
    public Produit getOne(int id) {
        Optional<Produit> prod = liste.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
        return prod.orElseThrow(ProduitNotFoundException::new);
    }

    @Override
    public boolean insert(Produit toAdd) {
        boolean result = false;
        if (toAdd != null && liste.stream().noneMatch(produit -> produit.getId() == toAdd.getId())){
            liste.add(toAdd);
            result = true;
        }
        return result;
    }


    @Override
    public Produit delete(int id) {
        Produit toDelete = getOne(id);
        liste.remove(toDelete);
        return toDelete;
    }

    @Override
    public void update(int id, ProduitForm form) {
        Produit p = getOne(id);
        if (liste.stream().anyMatch(produit -> produit.getId() == id)){
            liste.remove(p);
            p.setNom(form.getNom());
            p.setPrix(form.getPrix());
            liste.add(p);
        }
    }

    @Override
    public List<Produit> getAllSorted(Comparator<Produit> comparator) {
        return liste.stream()
                .sorted(comparator)
                .toList();
    }

    @Override
    public Produit getCheapest() {
        return liste.stream()
                .min(Comparator.comparingDouble(Produit::getPrix))
                .orElseThrow(NoProduitException::new);
    }

    @Override
    public Produit getMostExpensive() {
        return liste.stream()
                .max(Comparator.comparingDouble(Produit::getPrix))
                .orElseThrow(NoProduitException::new);
    }

    @Override
    public List<Produit> getAllByBrand(String brand) {
        return liste.stream()
                .filter(produit -> produit.getMarque().equals(brand))
                .toList();
    }
}
