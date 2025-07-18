package layered.architecture.clothing_shop.dao;

import layered.architecture.clothing_shop.model.Clothes;

import java.util.List;

public interface IClothesDAO {

    void save(Clothes clothes);
    List<Clothes> getAll();
    boolean deleteByName(String name);
    Clothes findByName(String name);
    boolean existsByName(String name);
    List<Clothes> findByCategory(String category);
    boolean updatePriceByName(String name, double newPrice);
    List<Clothes> findAllOutOfStock();
}
