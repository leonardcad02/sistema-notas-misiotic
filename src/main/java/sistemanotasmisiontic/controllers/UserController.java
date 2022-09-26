package sistemanotasmisiontic.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping
    public UserRest createUser (@RequestBody @Valid UserRegisterRequestModel userModel){
        UserEntity user = userService.creatUser(userModel);
        UserRest userRest = new UserRest();

        BeanUtils.copyProperties(user, userRest);
        return userRest;
    }
    @GetMapping
    public UserRest getUser (Authentication authentication){


        UserEntity user = userService.getUser(
                authentication.getPrincipal().toString()
        );
        UserRest userRest = new UserRest();

        BeanUtils.copyProperties(user, userRest);
        return userRest;
    }
}
