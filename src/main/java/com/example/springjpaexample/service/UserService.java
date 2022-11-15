package com.example.springjpaexample.service;

import com.example.springjpaexample.model.User;
import com.example.springjpaexample.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encode;

    public List<User> findAllUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User save(User user) {
        user.setPassword(encode.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User update(User user) {
        User currentInDB = findUserById(user.getId());
        if(user.getFirstName() == null) {
            user.setFirstName(currentInDB.getFirstName());
        }

        if (user.getLastName() == null) {
            user.setLastName(currentInDB.getLastName());
        }

        if (user.getLogin() == null) {
            user.setLogin(currentInDB.getLogin());
        }

        if (user.getPassword() == null) {
            user.setPassword(currentInDB.getPassword());
        } else {
            user.setPassword(encode.encode(user.getPassword()));
        }
        return userRepository.save(user);
    }

    public List<User> findByFirstAndLastName(String firstName, String lastName) {
        return userRepository.findAllByFirstNameAndLastName(firstName,lastName);
    }
}
