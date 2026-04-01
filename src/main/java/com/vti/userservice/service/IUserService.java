package com.vti.userservice.service;


import com.vti.userservice.dto.CreateUserReq;
import com.vti.userservice.entity.User;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface IUserService {
    User findById(Integer id);

    List<User> searchByPhoneNumberOrUsername(String phoneNumber, String username);

    User create(CreateUserReq newUser);

    Integer findIdByUsername(String username);
}
