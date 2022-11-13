package com.example.springjpaexample.web.mvc;

import com.example.springjpaexample.model.User;
import com.example.springjpaexample.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mvc")
public class WelcomeController {

    private final UserService userService;

//    @GetMapping
//    public String welcomePage() {
//        return "index";
//    }
    @GetMapping
    public String sayMore(ModelMap modelMap) {
        User user = userService.findUserById(2l);
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("sayMore", "dear " + user.getLastName());
        return "index";
    }

}
