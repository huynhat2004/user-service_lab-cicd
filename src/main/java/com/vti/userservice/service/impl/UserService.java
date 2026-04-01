package com.vti.userservice.service.impl;

import com.vti.userservice.dto.CreateUserReq;
import com.vti.userservice.entity.User;
import com.vti.userservice.entity.enumm.UserStatus;
import com.vti.userservice.exceptions.ApplicationException;
import com.vti.userservice.mapper.UserMapper;
import com.vti.userservice.repositories.UserRepository;
import com.vti.userservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(Integer id) {
        User user = userRepository.findUserById(id);
        if (user == null) {
            throw new ApplicationException("User not found!");
        }
        return user;
    }

    @Override
    public List<User> searchByPhoneNumberOrUsername(String phoneNumber, String username) {
        return userRepository.searchByPhoneNumberOrUsername(phoneNumber, username);
    }

    @Override
    public User create(CreateUserReq newUser) {
        User user = userMapper.fromCreateRequest(newUser);
        user.setStatus(UserStatus.ONLINE);
        user.setCreatedAt(Instant.now());
        return userRepository.save(user);
    }

    @Override
    public Integer findIdByUsername(String username) {
        User user = userRepository.findUserByUsername(username);
        return user.getId();
    }
}
