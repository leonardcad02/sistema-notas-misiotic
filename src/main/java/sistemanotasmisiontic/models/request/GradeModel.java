package sistemanotasmisiontic.models.request;
import lombok.Data;
import javax.validation.constraints.NotEmpty;

@Data
public class GradeModel {

    @NotEmpty
    private long idgrade;
}
