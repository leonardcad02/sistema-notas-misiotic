package sistemanotasmisiontic.entities;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "students")
@Data
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idstudent;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 255)
    private String lastname;

    @Column(nullable = false, length = 255)
    private long idgrade;

}