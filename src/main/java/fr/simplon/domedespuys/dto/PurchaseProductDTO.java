package fr.simplon.domedespuys.dto;

import fr.simplon.domedespuys.service.interfaces.IProductService;
import fr.simplon.domedespuys.validation.annotation.EntityExist;
import jakarta.validation.constraints.Min;

public class PurchaseProductDTO {

    @Min(value = 1, message = "Quantité incorrecte")
    public int quantity;

    @Min(value = 1, message = "Quantité incorrecte")
    public Long price;

    @EntityExist(serviceImpl = IProductService.class)
    public String productId;

}
