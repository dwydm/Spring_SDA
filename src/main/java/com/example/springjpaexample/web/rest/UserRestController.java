package com.example.springjpaexample.web.rest;

import com.example.springjpaexample.model.User;
import com.example.springjpaexample.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * GET /user, request GET http://localhost:8080/user
 * GET /user/{id}, request GET http://localhost:8080/user/1
 * POST /user
 * PUT /user
 * DELETE /user/{id}
 */


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserRestController {
    private final UserService userService;

    @GetMapping
    public List<User> getUserList() {
        return userService.findAllUsers();

    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @PatchMapping
    public User patchPassword(@RequestBody User user) {
        return userService.update(user);
    }

    @GetMapping("/search")
    public List<User> getUserByFirstAndLastName(@RequestParam("fn") String firstName, @RequestParam(value = "ln", required = true) String lastName) {
        return userService.findByFirstAndLastName(firstName,lastName);
    }


}
