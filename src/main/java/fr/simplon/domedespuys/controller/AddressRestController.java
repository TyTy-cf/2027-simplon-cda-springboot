package fr.simplon.domedespuys.controller;

import fr.simplon.domedespuys.dto.AddressDTO;
import fr.simplon.domedespuys.entity.Address;
import fr.simplon.domedespuys.repository.AddressRepository;
import fr.simplon.domedespuys.service.interfaces.IAddressService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/address")
@AllArgsConstructor
public class AddressRestController {

    private IAddressService addressService;

    @PostMapping
    public Address addAddress(@RequestBody AddressDTO address) {
        return addressService.create(address);
    }

}
