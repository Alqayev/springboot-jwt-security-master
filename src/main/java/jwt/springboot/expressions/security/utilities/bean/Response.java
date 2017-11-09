package jwt.springboot.expressions.security.utilities.bean;

import jwt.springboot.expressions.security.utilities.enums.ErrorHandl;

/**
 * @author Alqayev Taleh
 *
 * 2017 Nov 9, 2017 8:49:59 PM
 */
public class Response {
	public static Response SUCCESS = new Response(0, "ok");
	private int code;
	private String message;
	
	public Response(int code,String message){
		this.code = code;
		this.message = message;
	}
	
	public Response(ErrorHandl coreMessage){
		this.code = coreMessage.getErrorCode();
		this.message = coreMessage.toString();
	}
	
	public Response(){

	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
