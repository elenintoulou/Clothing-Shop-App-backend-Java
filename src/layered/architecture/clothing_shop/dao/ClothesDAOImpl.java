package layered.architecture.clothing_shop.dao;

import layered.architecture.clothing_shop.model.Clothes;

import java.util.ArrayList;
import java.util.List;

public class ClothesDAOImpl implements IClothesDAO {

    private final List<Clothes> clothesList = new ArrayList<>();

    @Override
    public void save(Clothes clothes) {
        clothesList.add(clothes);
    }

    @Override
    public List<Clothes> getAll() {
        return new ArrayList<>(clothesList);
    }

    @Override
    public boolean deleteByName(String name) {
        for (Clothes cloth : clothesList) {
            if (cloth.getName().equals(name)) {
                clothesList.remove(cloth);
                return true;
            }
        }
        return false;
    }

    @Override
    public Clothes findByName(String name) {
        for (Clothes cloth : clothesList) {
            if (cloth.getName().equalsIgnoreCase(name)) {
                return cloth;
            }
        }
        return null;
    }

    @Override
    public boolean existsByName(String name) {
        for (Clothes cloth : clothesList) {
            if (cloth.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public List<Clothes> findByCategory(String category) {
        List<Clothes> result = new ArrayList<>();

        for (Clothes cloth : clothesList) {
            if (cloth.getCategory().equalsIgnoreCase(category)) {
                result.add(cloth);
            }
        }
        return result;
    }

    @Override
    public boolean updatePriceByName(String name, double newPrice) {
        for (Clothes cloth : clothesList) {
            if (cloth.getName().equalsIgnoreCase(name)) {
                cloth.setPrice(newPrice);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Clothes> findAllOutOfStock() {
        List<Clothes> outOfStock = new ArrayList<>();//I make a new list for the clothes that are out of stock

        for (Clothes cloth : clothesList) {
            if (cloth.getStock() == 0) {
                outOfStock.add(cloth);
            }
        }
        return outOfStock;
    }
}
