package jwt.springboot.expressions.security.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;

/**
 * @author Alqayev Taleh
 *
 * 2017 Nov 7, 2017 8:50:31 PM
 */
@Target({ TYPE, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = EmailValidator.class)
@Documented
public @interface ValidEmail {

    String message() default "Invalid Email Format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
