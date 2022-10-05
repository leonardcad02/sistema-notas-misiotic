package sistemanotasmisiontic.entities;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "scores")
@Data
public class ScoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idscore;

    @Column(nullable = false, length = 255)
    private long idsubject;

    @Column(nullable = false, length = 255)
    private int finalscore;

    @Column(nullable = false, length = 255)
    private long idstudent;
}
