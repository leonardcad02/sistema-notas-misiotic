package sistemanotasmisiontic.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sistemanotasmisiontic.entities.UserEntity;
import sistemanotasmisiontic.models.request.UserRegisterRequestModel;
import sistemanotasmisiontic.repositories.UserRest;
import sistemanotasmisiontic.services.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping ("/users")
public class UserController {
    // POST, GET, DELETE, PUT, PATCH, OPTIONS

    @Autowired
    UserService userService;

    @PostMapping ()
    public UserRest createUser (@RequestBody @Valid UserRegisterRequestModel userModel){
        UserEntity user = userService.creatUser(userModel);
        UserRest userRest = new UserRest();

        BeanUtils.copyProperties(user, userRest);
        return userRest;
    }
}
