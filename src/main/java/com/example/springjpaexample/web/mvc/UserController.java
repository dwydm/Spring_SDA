package com.example.springjpaexample.web.mvc;

import com.example.springjpaexample.model.User;
import com.example.springjpaexample.service.UserService;
import com.example.springjpaexample.web.mvc.form.CreateUserForm;
import com.example.springjpaexample.web.mvc.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/mvc/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public String create(ModelMap modelMap) {
        modelMap.addAttribute("user", new CreateUserForm());
        modelMap.addAttribute("roles", User.RoleType.values());
        return "create-user";
    }

    @PostMapping
    public String handleCreate(@ModelAttribute("user") @Valid CreateUserForm form, Errors errors, final RedirectAttributes redirectAttributes, ModelMap modelMap) {
        log.info("Creating user from form: {}", form);
        if(errors.hasErrors()) {
            modelMap.addAttribute("roles", User.RoleType.values());
            return "create-user";
        }
        if(form.getId() != null){
            User user = userService.findUserById(form.getId());
            userService.update(UserMapper.updateUserDetails(user,form));
            redirectAttributes.addAttribute("message", "Dane użytkownika " + form.getLogin() + " zostały poprawnie zmienione");
            return "redirect:/mvc/user/userlist";
        } else {
            userService.save(UserMapper.toEntity(form));
            redirectAttributes.addAttribute("message", "Użytkownik " + form.getLogin() + " został dodany");
            return "redirect:/mvc/user/userlist";
        }
    }

    @GetMapping("/userlist")
    public String userList(ModelMap modelMap, @ModelAttribute("message") String message) {
        modelMap.addAttribute("users", userService.findAllUsers());
        if(!message.isEmpty() || message != null) {
            modelMap.addAttribute("message", message);
        }
        return "user-list";
    }

    @GetMapping("/edit/{id}")
    public String userEdit(ModelMap modelMap, @PathVariable("id") Long id) {
        modelMap.addAttribute("user", userService.findUserById(id));
        modelMap.addAttribute("roles", User.RoleType.values());
        return "create-user";
    }

    @GetMapping ("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/mvc/user/userlist";
    }
}
