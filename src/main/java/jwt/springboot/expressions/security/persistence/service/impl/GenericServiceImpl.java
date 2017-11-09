package jwt.springboot.expressions.security.persistence.service.impl;

import jwt.springboot.expressions.security.persistence.domain.RandomCity;
import jwt.springboot.expressions.security.persistence.domain.User;
import jwt.springboot.expressions.security.persistence.repository.RandomCityRepository;
import jwt.springboot.expressions.security.persistence.repository.UserRepository;
import jwt.springboot.expressions.security.persistence.service.GenericService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Alqayev Taleh
 *
 * 2017 Nov 9, 2017 8:49:39 PM
 */
@Service
public class GenericServiceImpl implements GenericService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RandomCityRepository randomCityRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>)userRepository.findAll();
    }

    @Override
    public List<RandomCity> findAllRandomCities() {
        return (List<RandomCity>)randomCityRepository.findAll();
    }
}
