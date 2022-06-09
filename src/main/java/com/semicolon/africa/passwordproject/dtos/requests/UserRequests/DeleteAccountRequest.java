package com.semicolon.africa.passwordproject.dtos.requests.UserRequests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class DeleteAccountRequest {
    private String username;
    private String password;
    private String emailAddress;
}
