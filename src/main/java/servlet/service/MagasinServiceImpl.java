package servlet.service;

import servlet.exceptions.MagasinNotFoundException;
import servlet.models.Magasin;
import streams.exo.models.Produit;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MagasinServiceImpl implements MagasinService{

    List<Magasin> liste = new ArrayList<>();
    private static MagasinServiceImpl _instance;

    public static MagasinServiceImpl getInstance(){
        if (_instance == null){
            _instance = new MagasinServiceImpl();
        }
        return _instance;
    }

    public MagasinServiceImpl() {
        liste.add(new Magasin(1, "La Caféière", "rue Longdoz", "Liège", 4020, 33, 120, 12));
        liste.add(new Magasin(2, "Chez Licour", "rue Saint-Gilles", "Liège", 4000, 230, 50, 25));
    }

    public List<Magasin> getAll() {
        return new ArrayList<>(liste);
    }

    public Magasin getOne(int id) {
        Optional<Magasin> mag = liste.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
        return mag.orElseThrow(MagasinNotFoundException::new);
    }

    //renvoie faux si le magasin n'est pas ajouté
    public boolean insert(Magasin toAdd) {
        boolean result = false;
        if (toAdd != null && liste.stream().noneMatch(magasin -> magasin.getId() == toAdd.getId())){
            liste.add(toAdd);
            result = true;
        }
        return result;
    }

    @Override
    public Magasin delete(int id) {
        Magasin toDelete = getOne(id);
        liste.remove(toDelete);
        return toDelete;
    }

    //renvoie faux si le produit n'est pas ajouté
//    boolean addProduit(int id_magasin, Produit produit) {
//        Produit p = getOne(id_magasin);
//        return false;
//    }

}
