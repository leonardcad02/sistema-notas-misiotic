package sistemanotasmisiontic.models.request;
import lombok.Data;
import javax.validation.constraints.NotEmpty;

@Data
public class StudentModel {

    @NotEmpty
    private String name;

    @NotEmpty
    private String lastname;

    @NotEmpty
    private long idgrade;

}
