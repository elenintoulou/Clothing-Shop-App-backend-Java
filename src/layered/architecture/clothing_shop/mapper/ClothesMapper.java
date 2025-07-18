package layered.architecture.clothing_shop.mapper;

import layered.architecture.clothing_shop.dto.ClothesDTO;
import layered.architecture.clothing_shop.model.Clothes;

public class ClothesMapper {

    private ClothesMapper() {
// no one should create an instance of this class that's why is private
    }

    public static Clothes mapToModelEntity (ClothesDTO dto) { //to translate the dto to object
        return new Clothes(dto.getName(), dto.getCategory(), dto.getPrice(), 0);
    }

    public static ClothesDTO mapToDTO (Clothes clothes) { //to translate the object to dto
        return new ClothesDTO(clothes.getName(), clothes.getCategory(), clothes.getPrice());
    }
}
