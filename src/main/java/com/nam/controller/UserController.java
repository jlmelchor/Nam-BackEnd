package com.nam.controller;

import com.nam.service.UserService;
import com.nam.data.model.NamUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {

    @Autowired
    UserService userService;

    // Devuelve un usuario
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public NamUser getUser(
            @PathVariable("id") Long userId
    ) {
        NamUser user = userService.getUser(userId);
        return user;
    }

    // Añade un usuario
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public NamUser addUser(
            @RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("email") String email,
            @RequestParam("password") String password
            ) {
        NamUser user = userService.addUser(name, surname, email, password);
        return user;
    }

    // Login -> Comprueba si un usuario existe mediante su email y contraseña
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public NamUser checkUser(
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ) {
        NamUser user = userService.checkUser(email, password);
        return user;
    }
}
