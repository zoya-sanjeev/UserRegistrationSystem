/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package UserRegistrationSystem;

import java.util.regex.Pattern;

public class UserRegistration {
	public boolean validateName(String name) {
		String nameValidation="^[A-Z][a-z]{2,}$";
		return Pattern.matches(nameValidation, name);
	}
}
