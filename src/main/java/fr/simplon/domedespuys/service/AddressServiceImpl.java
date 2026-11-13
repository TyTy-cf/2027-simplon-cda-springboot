package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.AddressDTO;
import fr.simplon.domedespuys.entity.Address;
import fr.simplon.domedespuys.entity.User;
import fr.simplon.domedespuys.repository.AddressRepository;
import fr.simplon.domedespuys.service.interfaces.IAddressService;
import fr.simplon.domedespuys.service.interfaces.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements IAddressService {

    private AddressRepository addressRepository;
    private IUserService userService;

    @Override
    public Address create(AddressDTO dto) {
        User user = userService.getById("1L");

        Address address = new Address();
        dtoToObject(dto, address);
        address.setUser(user);

        LocalDateTime date = LocalDateTime.now();
        address.setCreatedAt(date);

        addressRepository.saveAndFlush(address);
        return address;
    }

    @Override
    public boolean delete(String id) {
        try {
            addressRepository.deleteById(Long.parseLong(id));
            return true;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Address getById(String id) {
        return addressRepository
                .findById(Long.valueOf(id))
                .orElse(null);
    }

    @Override
    public Address update(String id, AddressDTO dto) {
        Address address = getById(id);
        if (address != null) {
            dtoToObject(dto, address);
            addressRepository.saveAndFlush(address);
        }
        return address;
    }

    private void dtoToObject(AddressDTO dto, Address address) {
        address.setLine(dto.line);
        address.setExtraLine(dto.extraLine);
        address.setCity(dto.city);
        address.setZipCode(dto.zipCode);
        address.setCountry(dto.country);
        address.setPhone(dto.phone);
        address.setFirstName(dto.firstName);
        address.setLastName(dto.lastName);
    }
}
