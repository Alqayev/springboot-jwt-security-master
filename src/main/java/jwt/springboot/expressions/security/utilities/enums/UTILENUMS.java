package jwt.springboot.expressions.security.utilities.enums;

/**
 * @author Alqayev Taleh
 *
 * 2017 Nov 9, 2017 8:50:09 PM
 */
public enum UTILENUMS {
	//send confirm code to user for complete user registration and buy secret code
	USER_REG_CONFIRM_W_GMAIL(1),
	USER_REG_CONFIRM_W_MESSAGE(2),
	USER_REG_CONFIRM_BY_ADMIN(3),
	
	//send notification to user with
	SEND_NOTIFICATION_GMAIL(1),
	SEND_NOTIFICATION_MESAGE(2),
	SEND_NOTIFICATION_MOB_APP(3),
	
	
	PERSON_ACTIVE(1),
	PERSON_PASSIVE(0);

	private UTILENUMS(int value) {
		this.value = value;
	}
	
	private int value;

	public int getValue() {
		return value;
	}
}
