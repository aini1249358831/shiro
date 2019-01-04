package com.example.shiro2.service;

import com.example.shiro2.entity.User;


public interface UserService {
    User findByUsername(String username);
    void delete(User user);
}
