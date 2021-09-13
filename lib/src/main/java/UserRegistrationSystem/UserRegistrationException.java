package UserRegistrationSystem;

public class UserRegistrationException extends RuntimeException{
	
	enum ExceptionType{
		NAME_NULL,
		NAME_INVALID,
		EMAIL_NULL,
		EMAIL_INVALID,
		PHONE_NULL,
		PHONE_INVALID,
		PASSWORD_INVALID_LENGTH,
		PASSWORD_UPPERCASE_MISSING,
		PASSWORD_DIGIT_MISSING,
		PASSWORD_SPECIALCHAR_MISSING,
		PASSWORD_NULL
	}
	ExceptionType type;
	
	public UserRegistrationException(String message, ExceptionType type ) {
		super(message);
		this.type=type;	
	}

}
