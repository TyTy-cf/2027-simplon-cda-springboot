package fr.simplon.domedespuys.controller;

import fr.simplon.domedespuys.entity.User;
import fr.simplon.domedespuys.service.interfaces.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserRestController {

    private IUserService userService;

    @GetMapping("/{id}")
    public User getItem(@PathVariable String id) {
        return userService.getById(id);
    }

}
