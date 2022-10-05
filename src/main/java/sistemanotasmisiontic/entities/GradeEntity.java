package sistemanotasmisiontic.entities;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "grades")
@Data
public class GradeEntity {

    @Id
    @Column(nullable = false, length = 255)
    private long idgrade;
}