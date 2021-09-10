package UserRegistrationSystem;

public class UserRegistrationException extends Exception{
	
	enum ExceptionType{
		NAME_NULL,
		NAME_INVALID,
		EMAIL_NULL,
		EMAIL_INVALID
	}
	ExceptionType type;
	
	public UserRegistrationException(String message, ExceptionType type ) {
		super(message);
		this.type=type;	
	}

}
