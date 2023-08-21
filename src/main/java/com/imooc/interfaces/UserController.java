package com.imooc.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imooc.application.UserApplication;
import com.imooc.domain.User;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserApplication userApplication;

    @PostMapping()
    public User create(@RequestBody User user) {
        return userApplication.create(user);
    }

    @GetMapping(value = "/{id}")
    public User findById(@PathVariable String id) {
        return userApplication.findById(id);
    }

}
