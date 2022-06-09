package com.semicolon.africa.passwordproject.dtos.requests.UserRequests;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequest {
    private String emailAddress;
    private String password;
}
