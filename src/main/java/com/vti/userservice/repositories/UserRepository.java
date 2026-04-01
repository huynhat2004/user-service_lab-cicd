package com.vti.userservice.repositories;

import com.vti.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(Integer id);

    List<User> searchByPhoneNumberOrUsername(String phoneNumber, String username);

    User findUserByUsername(String username);

}
