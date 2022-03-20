package com.sams.jwt.api.controller.Request;

import com.sams.jwt.service.AppUserService;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class LoginRequest {
    private final String email;
    private final String password;
}
