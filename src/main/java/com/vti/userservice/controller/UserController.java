package com.vti.userservice.controller;

import com.vti.userservice.dto.BaseResponse;
import com.vti.userservice.dto.CreateUserReq;
import com.vti.userservice.entity.User;
import com.vti.userservice.service.impl.UserService;
import jakarta.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<User>> findByID(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(new BaseResponse<>(userService.findById(id), "success"));
    }

    @GetMapping("/search")
    public ResponseEntity<BaseResponse<List<User>>> search(@QueryParam("keyword") String keyword) {
        return ResponseEntity.ok(new BaseResponse<>(userService.searchByPhoneNumberOrUsername(keyword, keyword), "success"));
    }

    @PostMapping("/create")
    public ResponseEntity<BaseResponse<User>> create(@RequestBody CreateUserReq createUserReq) {
        return ResponseEntity.ok(new BaseResponse<>(userService.create(createUserReq), "success"));
    }

    @GetMapping("")
    public Integer findIdByUsername(@QueryParam("username") String username) {
        return userService.findIdByUsername(username);
    }
}
