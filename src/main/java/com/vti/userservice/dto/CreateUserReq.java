package com.vti.userservice.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateUserReq {
    @NotEmpty
    private String username;

    @NotEmpty
    private String fullName;

    @NotEmpty
    private String phoneNumber;
}
