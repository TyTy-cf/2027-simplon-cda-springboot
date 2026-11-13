package fr.simplon.domedespuys.dto;

import fr.simplon.domedespuys.service.interfaces.IAddressService;
import fr.simplon.domedespuys.service.interfaces.IBrandService;
import fr.simplon.domedespuys.validation.annotation.EntityExist;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class ProductDTO {

    @NotBlank
    public String label;

    @NotBlank
    public String description;

    @Min(1)
    public int price;

    @EntityExist(serviceImpl = IBrandService.class)
    public String brandId;

    public List<ImageDTO> images;
}
