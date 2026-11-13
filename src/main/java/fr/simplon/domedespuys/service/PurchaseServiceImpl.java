package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.PurchasePostDTO;
import fr.simplon.domedespuys.dto.PurchasePutDTO;
import fr.simplon.domedespuys.entity.Address;
import fr.simplon.domedespuys.entity.EnumPurchaseStatus;
import fr.simplon.domedespuys.entity.Purchase;
import fr.simplon.domedespuys.exception.InvalidAddressException;
import fr.simplon.domedespuys.repository.PurchaseRepository;
import fr.simplon.domedespuys.service.interfaces.IAddressService;
import fr.simplon.domedespuys.service.interfaces.IPurchaseService;
import fr.simplon.domedespuys.service.interfaces.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PurchaseServiceImpl implements IPurchaseService {

    private PurchaseRepository purchaseRepository;
    private IAddressService addressService;
    private IUserService userService;

    @Override
    public Purchase create(PurchasePostDTO dto) {
        Purchase purchase = new Purchase();
        purchase.setStatus(EnumPurchaseStatus.PENDING.getValue());
        purchase.setUser(userService.getById("1"));

        Address address = addressService.getById(dto.addressId);
        if (address == null) {
            throw new InvalidAddressException();
        }

        // TODO : Check si Address.user == loggedUser

        purchase.setAddress(address);
        return purchase;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Purchase getById(String id) {
        return null;
    }

    @Override
    public Purchase update(String id, PurchasePutDTO dto) {
        return null;
    }
}
