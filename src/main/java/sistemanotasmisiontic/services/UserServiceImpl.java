package sistemanotasmisiontic.services;


import org.springframework.beans.BeanUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import sistemanotasmisiontic.entities.StudentEntity;
import sistemanotasmisiontic.entities.UserEntity;
import sistemanotasmisiontic.models.request.StudentModel;
import sistemanotasmisiontic.models.request.UserRegisterRequestModel;
import sistemanotasmisiontic.repositories.StudentRepository;
import sistemanotasmisiontic.repositories.UserRepository;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService{

    UserRepository userRepository;
    StudentRepository studentRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder;
    public UserServiceImpl ( UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, StudentRepository studentRepository){
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.studentRepository = studentRepository;
    }


    @Override
    public UserEntity creatUser(UserRegisterRequestModel user) {
        // Creamos una entidad
        UserEntity userEntity = new UserEntity();

        // copiamos toda la clase a userEntity
        BeanUtils.copyProperties(user, userEntity);

        userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));


        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity getUser(String email) {

        return userRepository.findByEmail(email);
    }

    @Override
    public StudentEntity createStudent(StudentModel student) {
        StudentEntity studentEntity = new StudentEntity();


        BeanUtils.copyProperties(student, studentEntity);


        return studentRepository.save(studentEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        UserEntity userEntity = userRepository.findByEmail(email);

        if(userEntity == null){
            System.out.println("Entro");
            throw new UsernameNotFoundException(email);
        }

        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
    }
}
