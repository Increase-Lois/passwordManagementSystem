package com.semicolon.africa.passwordproject.dtos.responses.UrlResponses;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UrlResponse {
    @NonNull
    private String urlAddress;
    @NonNull
    private String userName;



}
