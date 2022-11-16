package com.example.springjpaexample.web.mvc.form;

import com.example.springjpaexample.model.User;
import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CreateUserForm {
    private Long id;
    @NotBlank(message = "Pole nie może być puste")
    private String firstName;
    @NotBlank(message = "Pole nie może być puste")
    private String lastName;
    @NotBlank(message = "Pole nie może być puste")
    @Email(message = "Login musi mieć format e-mail")
    private String login;
    @Size(min = 8)
    @NotBlank(message = "Pole nie może być puste")
    private String password;
    private User.RoleType role;
}
