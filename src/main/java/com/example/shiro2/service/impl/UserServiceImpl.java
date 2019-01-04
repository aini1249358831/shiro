package com.example.shiro2.service.impl;
import com.example.shiro2.entity.User;
import com.example.shiro2.repository.UserRepository;
import com.example.shiro2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("")
public class UserServiceImpl implements UserService {
   @Autowired
    private UserRepository userRepository;
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(User user) {
        userRepository.delete(user);
    }
}
