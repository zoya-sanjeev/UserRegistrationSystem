/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package UserRegistrationSystem;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class UserRegistrationTest {
	String email;
	boolean expectedOutput;
	static int count=0;
	
	public UserRegistrationTest(String email,boolean expectedOutput) {
		this.email=email;
		this.expectedOutput=expectedOutput;
	}
	
	
    @Test public void validateName_ValidName_True() {
        
        try {
        	UserRegistration userRegistration = new UserRegistration();
			assertTrue(userRegistration.validateName("Zoya"));
		} catch (UserRegistrationException e) {
			
		}
    }
    @Test public void validateName_InvalidName_False() {
        
        try {
        	UserRegistration userRegistration = new UserRegistration();
			userRegistration.validateName("zoya");
		} catch (UserRegistrationException e) {
			Assert.assertEquals(UserRegistrationException.ExceptionType.NAME_INVALID, e.type);
		}
    }
    @Test public void validateName_NullName_False() {
        
        try {
        	UserRegistration userRegistration = new UserRegistration();
			userRegistration.validateName(null);
		} catch (UserRegistrationException e) {
			Assert.assertEquals(UserRegistrationException.ExceptionType.NAME_NULL, e.type);
		}
    }
    @Test public void validateEmail_ArrayOfValidAndInvalidEmails_TrueOrFalse() {
        
        try {
        	UserRegistration userRegistration = new UserRegistration();
			assertEquals(userRegistration.validateEmail(email),expectedOutput);
		} catch (UserRegistrationException e) {
			Assert.assertEquals(UserRegistrationException.ExceptionType.EMAIL_INVALID, e.type);
		}
    }
    @Test public void validateEmail_InvalidEmail_False() {
        
        try {
        	UserRegistration userRegistration = new UserRegistration();
			userRegistration.validateEmail("1ds@hsj.com");
		} catch (UserRegistrationException e) {
			Assert.assertEquals(UserRegistrationException.ExceptionType.EMAIL_INVALID, e.type);
		}
    }	
	@Test public void validateEmail_NullEmail_False() {
	        
		try {
	        UserRegistration userRegistration = new UserRegistration();
			userRegistration.validateEmail(null);
		} catch (UserRegistrationException e) {
			Assert.assertEquals(UserRegistrationException.ExceptionType.EMAIL_NULL, e.type);
		}
	}
	@Test public void validateEmail_ValidEmail_True() {
        
		try {
	        UserRegistration userRegistration = new UserRegistration();
			Assert.assertEquals(userRegistration.validateEmail("abc@yahoo.com"),true);
		} catch (UserRegistrationException e) {
			
		}
	}
    @Test public void validatePhone_ValidPhone_True() {
        
        try {
        	UserRegistration userRegistration = new UserRegistration();
			assertTrue(userRegistration.validatePhone("91 1234567890"));
		} catch (UserRegistrationException e) {
		}
    }
    @Test public void validateEmail_InvalidPhone_False() {
        UserRegistration userRegistration = new UserRegistration();
        try {
			userRegistration.validatePhone("1234 90191");
		} catch (UserRegistrationException e) {
			Assert.assertEquals(UserRegistrationException.ExceptionType.PHONE_INVALID,e.type);
		}
    }
    @Test public void validateEmail_NullPhone_False() {
        UserRegistration userRegistration = new UserRegistration();
        try {
			userRegistration.validatePhone(null);
		} catch (UserRegistrationException e) {
			Assert.assertEquals(UserRegistrationException.ExceptionType.PHONE_NULL,e.type);
		}
    }
    @Test public void validatePassword_ValidPasswordLength_True() {
        
        try {
        	UserRegistration userRegistration = new UserRegistration();
			assertTrue(userRegistration.validatePassword("Password@123"));
		} catch (UserRegistrationException e) {

		}
    }
    @Test public void validatePassword_InvalidPasswordLength_False() {
        
        try {
        	UserRegistration userRegistration = new UserRegistration();
			userRegistration.validatePassword("Pas@1");
		} catch (UserRegistrationException e) {
			Assert.assertEquals(UserRegistrationException.ExceptionType.PASSWORD_INVALID_LENGTH,e.type);
		}
    }
    @Test public void validatePassword_PasswordWithOneUpperCase_True() {
        
        try {
        	UserRegistration userRegistration = new UserRegistration();
			assertTrue(userRegistration.validatePassword("Password@123"));
		} catch (UserRegistrationException e) {
			
		}
    }
    @Test public void validatePassword_PasswordWithNoUpperCase_False() {
        
        try {
        	UserRegistration userRegistration = new UserRegistration();
			userRegistration.validatePassword("pass1word@");
		} catch (UserRegistrationException e) {
			Assert.assertEquals(UserRegistrationException.ExceptionType.PASSWORD_UPPERCASE_MISSING,e.type);
		}
    }
    @Test public void validatePassword_PasswordWithOneDigit_True() {
        
        try {
        	UserRegistration userRegistration = new UserRegistration();
			assertTrue(userRegistration.validatePassword("Password1@"));
		} catch (UserRegistrationException e) {
			
		}
    }
    @Test public void validatePassword_PasswordWithNoDigit_False() {
        
        try {
        	UserRegistration userRegistration = new UserRegistration();
			userRegistration.validatePassword("Password@");
		} catch (UserRegistrationException e) {
			Assert.assertEquals(UserRegistrationException.ExceptionType.PASSWORD_DIGIT_MISSING,e.type);
		}
    }
    @Test public void validatePassword_PasswordWithOneSpecialCharacter_True() {
        
        try {
        	UserRegistration userRegistration = new UserRegistration();
			assertTrue(userRegistration.validatePassword("Password1@#@"));
		} catch (UserRegistrationException e) {
			
		}
    }
    @Test public void validatePassword_PasswordWithNoSpecialCharacter_False() {
       
        try {
        	 UserRegistration userRegistration = new UserRegistration();
			userRegistration.validatePassword("Passwor1d");
		} catch (UserRegistrationException e) {
			Assert.assertEquals(UserRegistrationException.ExceptionType.PASSWORD_SPECIALCHAR_MISSING,e.type);
		}
    }
    @Test public void validatePassword_NullPassword_False() {
        
        try {
        	 UserRegistration userRegistration = new UserRegistration();
			userRegistration.validatePassword(null);
		} catch (UserRegistrationException e) {
			Assert.assertEquals(UserRegistrationException.ExceptionType.PASSWORD_NULL,e.type);
		}
    }

	@Parameterized.Parameters
	public static Collection input(){
		return Arrays.asList(new Object[][] { { "abc@yahoo.com",true }, { "abc-100@yahoo.com",true }, { "abc.100@yahoo.com",true },
			{ "abc111@abc.com",true }, { "abc-100@abc.net",true }, { "abc.100@abc.com.au",true }, { "abc@1.com",true },
			{ "abc@gmail.com.com",true }, { "abc+100@gmail.com",true }, { "abc",false }, { "abc@.com.my",false }, { "abc123@gmail.a",false },
			{ "abc123@.com",false }, { "abc123@.com.com",false }, { ".abc@abc.com",false }, { "abc()@gmail.com",false }, { "abc@%.com",false },
			{ "abc..2002@gmail.com",false }, { "abc.@gmail.com",false }, { "abc@abc@gmail.com",false }, { "abc@gmail.com.1a",false },
			{ "abc@gmail.com.aa.au",false } });
	}
}
