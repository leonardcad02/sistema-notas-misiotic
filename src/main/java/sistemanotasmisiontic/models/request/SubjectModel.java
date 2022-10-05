package sistemanotasmisiontic.models.request;
import lombok.Data;
import javax.validation.constraints.NotEmpty;

@Data
public class SubjectModel {

    @NotEmpty
    private long idsubject;

    @NotEmpty
    private String name;
}
