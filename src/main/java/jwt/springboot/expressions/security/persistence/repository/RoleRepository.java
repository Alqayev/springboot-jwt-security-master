package jwt.springboot.expressions.security.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import jwt.springboot.expressions.security.persistence.domain.Role;


/**
 * @author Alqayev Taleh
 *
 * 2017 Nov 9, 2017 8:48:48 PM
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
}
