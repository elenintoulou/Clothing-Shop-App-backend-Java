package layered.architecture.clothing_shop.service;

import layered.architecture.clothing_shop.dto.ClothesDTO;

import java.util.List;

public interface IClothesService {

    void addClothes(ClothesDTO dto);
    List<ClothesDTO> findAllClothes();
    boolean deleteClothesByName(String name);
    ClothesDTO findClothesByName(String name);
    List<ClothesDTO> findClothesByCategory(String category);
    List<ClothesDTO> findAllOutOfStock();
    boolean updatePrice(String name, double newPrice);
}
