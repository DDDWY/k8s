package com.imooc.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.domain.User;
import com.imooc.repository.UserRepository;

@Service
public class UserApplication {

    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    public User findById(String id) {
        return userRepository.findOne(id);
    }

}
