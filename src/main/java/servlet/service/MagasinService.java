package servlet.service;

import streams.exo.models.Magasin;
import streams.exo.models.Produit;

import java.util.List;

public class MagasinService {

    List<Magasin> getAll() {
        return null;
    }

    Magasin getOne(int id) {
        return null;
    }

    //renvoie faux si le magasin n'est pas ajouté
    boolean insert(Magasin toAdd) {
        return false;
    }

    //renvoie faux si le produit n'est pas ajouté
    boolean addProduit(int id_magasin, Produit produit) {
        return false;
    }

}
