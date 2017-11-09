package jwt.springboot.expressions.security.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jwt.springboot.expressions.security.persistence.domain.RandomCity;
import jwt.springboot.expressions.security.persistence.domain.User;
import jwt.springboot.expressions.security.persistence.service.GenericService;


/**
 * @author Alqayev Taleh
 *
 * 2017 Nov 9, 2017 8:51:04 PM
 */
@RestController
@RequestMapping("/springjwt")
public class ResourceController {
    @Autowired
    private GenericService userService;

    @RequestMapping(value ="/cities")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    public List<RandomCity> getUser(){
        return userService.findAllRandomCities();
    }

    @PostMapping(value = "/users")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getUsers(){
        return userService.findAllUsers();
    }
}
