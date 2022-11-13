package com.example.springjpaexample.service;

import com.example.springjpaexample.model.User;
import com.example.springjpaexample.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserRepositoryTestService implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
//        userRepository.save(new User("Bob", "Dywan", "dywan5", "password"));
//        userRepository.save(new User("Michael", "Klakson", "klakson", "password2"));
//        userRepository.save(new User("Jason", "Domofon", "domffz", "password3"));
//        userRepository.save(new User("Tobias", "Rieper", "c47", "**********"));
//            userRepository.save(new User("Bob", "Dywan", "cdwdw", "*asd*"));

//        log.info("List of all users");
//        printAllUsers();
//
//        log.info("Find by user id:");
//        userRepository.findById(2l).ifPresent(user -> log.info(user.toString()));

//        log.info("Delete user by user id:");
//        userRepository.deleteById(4l);
//        printAllUsers();

//        log.info("Update user details");
//        userRepository.findById(2l).ifPresent(user -> {
//            user.setFirstName("Majkel");
//            userRepository.save(user);
//
//        });

//        userRepository.findAllByLastName("Klakson").forEach(user -> log.info(user.toString()));
//        userRepository.findAllByFirstNameAndLastName("Jason", "Domofon").forEach(user -> log.info(user.toString()));
//
//        userRepository.findByLogin("c47").ifPresent(user -> log.info(user.toString()));
//
//        userRepository.findTop2ById(2l);
//        log.info("native query");
//        userRepository.findByLoginNative("c47").ifPresent(user -> log.info(user.toString()));
    }

//    private void printAllUsers() {
//        userRepository.findAll().forEach(user -> log.info(user.toString()));
//    }
}
