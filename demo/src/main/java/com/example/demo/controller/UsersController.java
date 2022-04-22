package com.example.demo.controller;

import com.example.demo.entity.Users;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private Users login(@RequestBody Users users){
        return usersService.login(users.getAccount(), users.getPassword());
    }

    @RequestMapping(value = "/pull", method = RequestMethod.POST)
    private Users pull(@RequestParam String account){
        return usersService.pull(account);
    }

    @RequestMapping(value = "/sign_up", method = RequestMethod.POST)
    private void sign_up(@RequestParam String account, @RequestParam String password, @RequestParam String user_name){
        usersService.sign_up(account, password, user_name);
    }
}
