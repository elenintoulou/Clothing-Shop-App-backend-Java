package layered.architecture.clothing_shop.service;

import layered.architecture.clothing_shop.dao.IClothesDAO;
import layered.architecture.clothing_shop.dto.ClothesDTO;
import layered.architecture.clothing_shop.mapper.ClothesMapper;
import layered.architecture.clothing_shop.model.Clothes;

import java.util.List;
import java.util.stream.Collectors;

public class ClothesServiceImpl implements IClothesService{

    private final IClothesDAO clothesDAO; //logika gia na ferw ta dedomena apo DAO???


    public ClothesServiceImpl(IClothesDAO clothesDAO) {
        this.clothesDAO = clothesDAO;
    }

    @Override
    public void addClothes(ClothesDTO dto) {
        Clothes clothes = ClothesMapper.mapToModelEntity(dto);//Use the mapper to turn DTO into Model
        clothesDAO.save(clothes); // i call the method i made in DAO now that the data is in the right datatype!
    }

    @Override
    public List<ClothesDTO> findAllClothes() {
        List<Clothes> clothes = clothesDAO.getAll();

        return clothes.stream()
                .map(ClothesMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteClothesByName(String name) {
        return clothesDAO.deleteByName(name);
    }

    @Override
    public ClothesDTO findClothesByName(String name) {
       Clothes clothes = clothesDAO.findByName(name);
        return ClothesMapper.mapToDTO(clothes);
    }

    @Override
    public List<ClothesDTO> findClothesByCategory(String category) {
        List<Clothes> clothes = clothesDAO.findByCategory(category);// create a new list by category
        if (clothes == null) return List.of();
        return clothes.stream().map(ClothesMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ClothesDTO> findAllOutOfStock() {
        List<Clothes> clothes = clothesDAO.findAllOutOfStock();

        if (clothes == null) return List.of();
        return clothes.stream().map(ClothesMapper::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public boolean updatePrice(String name, double newPrice) {

        if (name == null) return false;
        return clothesDAO.updatePriceByName(name, newPrice);
    }
}
