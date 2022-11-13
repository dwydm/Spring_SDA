package com.example.springjpaexample.repository;

import com.example.springjpaexample.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAllByLastName(String lastName);
    List<User> findAllByFirstNameAndLastName(String firstName, String lastName);

    Optional<User> findByLogin(String login);

    List<User> findTop2ById(Long id);

    @Query("select u from User u where u.password = :password")
    List<User> findByPassword(@Param("password") String password);

    @Query(value = "select * from User where login = :login", nativeQuery = true)
    Optional<User> findByLoginNative(@Param("login") String login);

}
