package com.vti.userservice.mapper;

import com.vti.userservice.dto.CreateUserReq;
import com.vti.userservice.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User fromCreateRequest(CreateUserReq createUserReq);
}
