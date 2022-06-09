package com.semicolon.africa.passwordproject.dtos.requests.UrlRequests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UrlUpdateRequest {
    private String urlAddress;
    private String oldPassWord;
    private String newPassWord;
}
