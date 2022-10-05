package sistemanotasmisiontic.repositories;


import lombok.Data;

@Data
public class UserRest {

    private long id;

    private String name;

    private String lastname;

    private String email;

    private String encryptedPassword;

    private String cc;

    private String rol;




}
