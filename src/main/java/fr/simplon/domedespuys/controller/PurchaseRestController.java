
package fr.simplon.domedespuys.controller;

import fr.simplon.domedespuys.dto.PurchasePostDTO;
import fr.simplon.domedespuys.entity.Purchase;
import fr.simplon.domedespuys.service.interfaces.IPurchaseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/purchase")
@AllArgsConstructor
public class PurchaseRestController {

    private IPurchaseService purchaseService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Purchase create(@RequestBody PurchasePostDTO purchase) {
        return purchaseService.create(purchase);
    }

}
