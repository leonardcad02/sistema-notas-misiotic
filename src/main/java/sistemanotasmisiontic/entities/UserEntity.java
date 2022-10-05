package sistemanotasmisiontic.entities;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "users")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 255)
    private String lastname;

    @Column(nullable = false, length = 255)
    private String email;

    @Column(nullable = false)
    private String encryptedPassword;

    @Column(nullable = false, length = 255)
    private String cc;

    @Column(nullable = false, length = 255)
    private String rol;

}
