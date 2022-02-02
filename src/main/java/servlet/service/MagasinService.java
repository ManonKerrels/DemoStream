package servlet.service;

import servlet.models.Magasin;

import java.util.List;

public interface MagasinService {
    List<Magasin> getAll();
    Magasin getOne(int id);

    boolean insert(Magasin toAdd);

    Magasin delete(int id);
}
