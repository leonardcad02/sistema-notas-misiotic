package sistemanotasmisiontic.models.request;

import lombok.Data;
import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Data
public class UserLoginRequestModel {

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String password;
}
