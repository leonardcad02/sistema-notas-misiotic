package sistemanotasmisiontic.validator;

import org.springframework.beans.factory.annotation.Autowired;
import sistemanotasmisiontic.annotations.UniqueEmail;
import sistemanotasmisiontic.entities.UserEntity;
import sistemanotasmisiontic.repositories.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator <UniqueEmail, String> {

    @Autowired
    UserRepository userRepository;
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        UserEntity user = userRepository.findByEmail(value);
        if (user == null) {
            return true;
        }
        return false;
    }
}
