package sistemanotasmisiontic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sistemanotasmisiontic.entities.StudentEntity;


@Repository
public interface StudentRepository extends CrudRepository <StudentEntity, Long> {



}
