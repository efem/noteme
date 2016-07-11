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
		String passVerify = user.getPasswordVerify();
		
		if (!password.equals(passVerify)){
			errors.rejectValue("password", "user.password.missMatch");
		}
		
	}

}
