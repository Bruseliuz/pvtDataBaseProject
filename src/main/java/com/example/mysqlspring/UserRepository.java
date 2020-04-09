package com.example.mysqlspring;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer>{
    User findByEmailAndPassword(String email, String password);

    User findByEmail(String email);
}
