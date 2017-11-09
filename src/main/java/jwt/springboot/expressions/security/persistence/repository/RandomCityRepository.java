package jwt.springboot.expressions.security.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import jwt.springboot.expressions.security.persistence.domain.RandomCity;


/**
 * @author Alqayev Taleh
 *
 * 2017 Nov 9, 2017 8:48:42 PM
 */
public interface RandomCityRepository extends CrudRepository<RandomCity, Long> {
}
