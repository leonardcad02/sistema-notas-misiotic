package sistemanotasmisiontic.repositories;

import lombok.Data;

@Data
public class StudentRest {

    private long idstudent;

    private String name;

    private String lastname;

    private long idgrade;
}
