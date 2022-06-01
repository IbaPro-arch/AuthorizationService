package com.example.authorizationservice.Controller;

import com.example.authorizationservice.Entity.User;
import com.example.authorizationservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class OauthController {

    @Autowired
    UserService authService;

    @GetMapping("/admin")
    public String userList(Model model) {
        model.addAttribute("allUsers", authService.allUsers());
        return "admin";
    }

    @DeleteMapping("/admin/{bookId}")
    public void deleteBook(@PathVariable Integer bookId) {
        authService.deleteBook(bookId);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user, Map<String, Object> model) {
        return authService.saveUser(user, model);
    }
}
