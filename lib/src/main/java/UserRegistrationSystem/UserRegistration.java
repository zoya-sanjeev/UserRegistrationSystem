/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package UserRegistrationSystem;

import java.util.regex.Pattern;

import UserRegistrationSystem.UserRegistrationException.ExceptionType;

public class UserRegistration {
	public boolean validateName(String name)throws UserRegistrationException {
		try {
		String nameValidation="^[A-Z][a-z]{2,}$";
		if(Pattern.matches(nameValidation, name))
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
		if(Pattern.matches(emailValidation,email))
			return true;
		else
			throw new UserRegistrationException("Enter email in proper format", ExceptionType.EMAIL_INVALID);
		}catch(NullPointerException e) {
			throw new UserRegistrationException("Enter name in proper format",ExceptionType.EMAIL_NULL);
		}
	}
	
	public static boolean validatePhone(String phoneNumber) {
		String phoneValidation="^[0-9]{2,3}\\s[0-9]{10}$";
		return Pattern.matches(phoneValidation,phoneNumber);
	}
	
	public static boolean validatePassword(String password) {
		String passwordValidation="^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}$";
		return Pattern.matches(passwordValidation,password);
	}
}
