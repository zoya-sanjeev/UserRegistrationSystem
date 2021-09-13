/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package UserRegistrationSystem;

import java.util.regex.Pattern;
import UserRegistrationSystem.UserRegistrationException.ExceptionType;

@FunctionalInterface
interface IValidate{
	boolean validate(String regex,String input);
}


public class UserRegistration {
	static IValidate validateInput=(String regex, String input)->{
		boolean result=Pattern.matches(regex,input);
		return result;
	};
	
	public boolean validateName(String name)throws UserRegistrationException {
		try {
		String nameValidation="^[A-Z][a-z]{2,}$";
		if(UserRegistration.validateInput.validate(nameValidation, name))
			return true;
		else {
			throw new UserRegistrationException("Enter name in proper format",ExceptionType.NAME_INVALID);
		}
		}catch(NullPointerException e) {
			throw new UserRegistrationException("Enter name in proper format",ExceptionType.NAME_NULL);
		}
	}
	
	public static boolean validateEmail(String email) throws UserRegistrationException {
		try {
			String emailValidation="^[a-zA-Z]{1,}([\\.\\_\\-\\+]?[a-zA-Z0-9]+)@[a-z0-9]+[.][a-z]+[.]?[a-z]{2,3}?$";
			if(UserRegistration.validateInput.validate(emailValidation , email))
				return true;
			else
				throw new UserRegistrationException("Enter email in proper format", ExceptionType.EMAIL_INVALID);
		}catch(NullPointerException e) {
			throw new UserRegistrationException("Enter name in proper format",ExceptionType.EMAIL_NULL);
		}
	}
	
	public static boolean validatePhone(String phoneNumber) throws UserRegistrationException {
		try {
			String phoneValidation="^[0-9]{2,3}\\s[0-9]{10}$";
			if(UserRegistration.validateInput.validate(phoneValidation,phoneNumber ))
				return true;
			else
				throw new UserRegistrationException("Enter phone number in proper format",ExceptionType.PHONE_INVALID);
		}catch(NullPointerException e) {
			throw new UserRegistrationException("Enter phone number in proper format",ExceptionType.PHONE_NULL);
		}
	}
	
	public static boolean validatePassword(String password) throws UserRegistrationException {
		try {
			String passwordLengthValidation=".{8,}";
			String passwordUpperCaseValidation="(?=.*[A-Z])";
			String passwordSpecialCharValidation="(?=.*[@#$%^&+=])";
			String passwordDigitValidation="(?=.*[0-9])";
			if(UserRegistration.validateInput.validate("^"+passwordUpperCaseValidation+passwordDigitValidation+passwordSpecialCharValidation+passwordLengthValidation+"$",password))
				return true;
			else if(!UserRegistration.validateInput.validate(passwordDigitValidation+".{1,}", password))
				throw new UserRegistrationException("Enter at least one digit", ExceptionType.PASSWORD_DIGIT_MISSING);
			else if(!UserRegistration.validateInput.validate(passwordUpperCaseValidation+".{1,}", password))
				throw new UserRegistrationException("Enter at least one uppercase letter", ExceptionType.PASSWORD_UPPERCASE_MISSING);
			else if(!UserRegistration.validateInput.validate(passwordSpecialCharValidation+".{1,}", password))
				throw new UserRegistrationException("Enter at least one special character", ExceptionType.PASSWORD_SPECIALCHAR_MISSING);
			else if(password.length()<8)
				throw new UserRegistrationException("Enter at least 8 characters",ExceptionType.PASSWORD_INVALID_LENGTH);
			else
				return false;
		}catch(NullPointerException e) {
			throw new UserRegistrationException("Enter password in proper format",ExceptionType.PASSWORD_NULL);
		}
	}
}
