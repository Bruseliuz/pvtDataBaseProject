package com.example.mysqlspring;

import org.springframework.data.repository.CrudRepository;
import sun.security.util.Password;
import javax.validation.constraints.Email;

public interface UserRepository extends CrudRepository<User, Integer>{
    User findByEmailAndPassword(String email, String password);
}
