package com.semicolon.africa.passwordproject.dtos.requests.UrlRequests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteUrlRequest {
    private String urlAddress;
    private String password;
}
