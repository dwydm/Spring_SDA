package com.example.springjpaexample.web.mvc.mappers;

import com.example.springjpaexample.model.User;
import com.example.springjpaexample.web.mvc.form.CreateUserForm;

public class UserMapper {

    public static User toEntity(CreateUserForm form) {
        return new User(form.getFirstName(), form.getLastName(), form.getLogin(), form.getPassword(), form.getRole());
    }

    public static User updateUserDetails(User user, CreateUserForm form) {
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setLogin(form.getLogin());
        user.setPassword(form.getPassword());
        user.setRole(form.getRole());
        return user;
    }
}
