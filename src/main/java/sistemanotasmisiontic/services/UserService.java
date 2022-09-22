package sistemanotasmisiontic.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import sistemanotasmisiontic.entities.UserEntity;
import sistemanotasmisiontic.models.request.UserRegisterRequestModel;

public interface UserService extends UserDetailsService {
    public UserDetails loadUserByUsername (String email);
    public UserEntity creatUser(UserRegisterRequestModel user);
}
