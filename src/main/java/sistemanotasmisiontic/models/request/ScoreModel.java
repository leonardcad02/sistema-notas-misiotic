package sistemanotasmisiontic.models.request;

import javax.persistence.Column;
import lombok.Data;
import javax.validation.constraints.NotEmpty;

@Data
public class ScoreModel {

    @NotEmpty
    private long idsubject;

    @NotEmpty
    private int finalscore;

    @NotEmpty
    private long idstudent;
}
