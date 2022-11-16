package com.example.springjpaexample;

import com.example.springjpaexample.model.User;
import com.example.springjpaexample.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(value = "classpath:application-test.properties")
public class BaseTest {
    @Autowired
    protected UserRepository repository;
    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected ObjectMapper objectMapper;

    @BeforeEach
    void beforeEach(@Autowired UserRepository userRepository) {
        repository.save(new User("Jan", "Kowalski", "janko@walski.com", "12233456", User.RoleType.ROLE_ADMIN));
        repository.save(new User("Anna", "Kowalski", "annako@walski.com", "12233456", User.RoleType.ROLE_USER));
        repository.save(new User("Marta", "Uparta", "martau@parta.xc", "12233456", User.RoleType.ROLE_USER));
        repository.save(new User("admin", "nullpointer", "admin@null.pl", "$2a$10$Ews8BJ59mSwgmK6TWFLTXuq5OFn8es1S2s45GigWtGoC4t4towy4a", User.RoleType.ROLE_ADMIN));

    }
    @AfterEach
    void afterEach() {
        repository.deleteAll();
    }
}
