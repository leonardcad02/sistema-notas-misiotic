package sistemanotasmisiontic.annotations;

import sistemanotasmisiontic.validator.UniqueEmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueEmailValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail {
    String message() default "{sistemanotasmisiontic.constraints.email.unique.message}";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
