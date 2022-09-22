package sistemanotasmisiontic.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sistemanotasmisiontic.entities.UserEntity;

@Repository
public interface UserRepository extends CrudRepository <UserEntity, Long> {
    public UserEntity findByEmail(String email);
}
