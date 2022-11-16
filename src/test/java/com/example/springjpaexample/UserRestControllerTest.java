package com.example.springjpaexample;

import com.example.springjpaexample.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


public class UserRestControllerTest extends BaseTest{


    @Test
    void shouldSendPostForUserCreation() throws Exception {
        //given
        //when
        //then
        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization","Basic YWRtaW5AbnVsbC5wbDoxMjNmcnl0a2k=")
                .content(objectMapper.writeValueAsString(new User("Bobek", "Kozi", "kozi@bobek.pl", "qwertyui", User.RoleType.ROLE_USER))))
                .andExpect(MockMvcResultMatchers.status().isCreated());



    }
}
