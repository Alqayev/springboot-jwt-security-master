package jwt.springboot.expressions.security.utilities;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;


/**
 * @author Alqayev Taleh
 *
 * 2017 Nov 9, 2017 8:50:15 PM
 */
@Component
public class TimeProvider implements Serializable {

    private static final long serialVersionUID = -3301695478208950415L;

    public Date now() {
        return new Date();
    }
}
