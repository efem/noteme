package info.noteme.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import info.noteme.domain.User;

@Component
public class PassValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User)target;
		
		String password = user.getPassword();
		String passwordVerify = user.getPasswordVerify();
		
		if (!password.equals(passwordVerify)){
			errors.rejectValue("passwordVerify", "user.password.missMatch");
		}
		
		if (password.length() < 5 || password.length() > 20) {
			errors.rejectValue("password", "user.password.wronglength");
		}
		
	}

}
