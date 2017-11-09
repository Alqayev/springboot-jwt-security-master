package jwt.springboot.expressions.security.utilities.enums;

import java.util.Arrays;
import java.util.List;

/**
 * @author Alqayev Taleh
 *
 * 2017 Nov 9, 2017 8:50:05 PM
 */
public enum ErrorHandl {
	USER_ALREADY_EXIST(1),
	USER_NOT_FOUND(2),
	INVALID_HEADER(3),
	ILLEGAL_ARGUMENT_IN_JWT(4),
	USERNAME_NOT_FOUND(5),
	EXPIRED_JWT(5),
	GENERAL_ERROR(666);
	
	private int errorCode;

	private ErrorHandl(int errorCode) {
		this.setErrorCode(errorCode);
	}

	private void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}


	public static boolean isCoreMessages(String value) {
		for (ErrorHandl me : ErrorHandl.values()) {
			if (String.valueOf(me.getErrorCode()).equalsIgnoreCase(value))
				return true;
		}
		return false;
	}

	public static ErrorHandl getObject(String value) {
		for (ErrorHandl me : ErrorHandl.values()) {
			if (String.valueOf(me.getErrorCode()).equalsIgnoreCase(value))
				return me;
		}
		return GENERAL_ERROR;
	}

	public static int getValue(String name) {
		for (ErrorHandl me : ErrorHandl.values()) {
			if (me.name().equalsIgnoreCase(name))
				return me.getErrorCode();
		}
		return GENERAL_ERROR.errorCode;
	}

	public List<ErrorHandl> getValues(){
		return Arrays.asList(ErrorHandl.values());
	}
}
