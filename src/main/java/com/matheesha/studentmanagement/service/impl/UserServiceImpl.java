package com.matheesha.studentmanagement.service.impl;

import com.matheesha.studentmanagement.entity.UserInfo;
import com.matheesha.studentmanagement.repository.UserRepository;
import com.matheesha.studentmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userRepository.save(userInfo);
        return "User: " + userInfo.getName() + " added to the System";
    }
}
