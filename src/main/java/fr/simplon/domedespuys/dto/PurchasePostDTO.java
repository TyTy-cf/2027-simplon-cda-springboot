package fr.simplon.domedespuys.dto;

import fr.simplon.domedespuys.service.interfaces.IAddressService;
import fr.simplon.domedespuys.validation.annotation.EntityExist;

import java.util.List;

public class PurchasePostDTO {

    @EntityExist(serviceImpl = IAddressService.class)
    public String addressId;

    public List<PurchaseProductDTO> purchaseProdcutDTOList;

}
