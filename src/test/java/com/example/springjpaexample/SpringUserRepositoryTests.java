package com.example.springjpaexample;

import com.example.springjpaexample.model.User;
import com.example.springjpaexample.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SpringUserRepositoryTests extends BaseTest {

    @Test
    void shouldCreateUser() {
        //given
        User user = new User("Bob", "Dywan", "bobdy@wan.com", "12233456", User.RoleType.ROLE_ADMIN);
        //when
        User saved = repository.save(user);

        //then
        assertNotNull(saved);
        assertNotNull(saved.getId());
        assertEquals("Bob", saved.getFirstName());
        assertEquals(User.RoleType.ROLE_ADMIN, saved.getRole());
    }
    @Test
    void shouldFindAllUsersByLastName() {
        //given

        //when
        List<User> users = repository.findAllByLastName("Kowalski");
        //then
        assertEquals(2,users.size());

    }

/*    @Test
    void contextLoads() {
    }*/

}
