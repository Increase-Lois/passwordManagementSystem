package com.semicolon.africa.passwordproject.dtos.requests.UrlRequests;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UrlRequest {

    private String userName;

    private String urlAddress;

    private String password;

    private String emailAddress;



}
