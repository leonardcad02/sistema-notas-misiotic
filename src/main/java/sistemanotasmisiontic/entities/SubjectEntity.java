package sistemanotasmisiontic.entities;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "subjects")
@Data
public class SubjectEntity {

    @Id
    @Column(nullable = false, length = 255)
    private long idsubject;

    @Column(nullable = false, length = 255)
    private String name;
}
