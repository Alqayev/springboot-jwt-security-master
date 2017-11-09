package jwt.springboot.expressions.security.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import jwt.springboot.expressions.security.persistence.domain.User;

/**
 * @author Alqayev Taleh
 *
 * 2017 Nov 9, 2017 8:48:52 PM
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
