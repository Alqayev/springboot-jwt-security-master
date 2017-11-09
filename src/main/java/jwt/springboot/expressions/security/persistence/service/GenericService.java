package jwt.springboot.expressions.security.persistence.service;

import jwt.springboot.expressions.security.persistence.domain.RandomCity;
import jwt.springboot.expressions.security.persistence.domain.User;

import java.util.List;


/**
 * @author Alqayev Taleh
 *
 * 2017 Nov 9, 2017 8:49:52 PM
 */
public interface GenericService {
    User findByUsername(String username);

    List<User> findAllUsers();

    List<RandomCity> findAllRandomCities();
}
