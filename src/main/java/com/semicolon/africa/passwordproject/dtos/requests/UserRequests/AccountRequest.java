package com.semicolon.africa.passwordproject.dtos.requests.UserRequests;

import lombok.*;


@Data

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountRequest {
    private String firstName;
    private String lastName;
    @NonNull
    private String userName;
    @NonNull
    private String password;
    @NonNull
    private String emailAddress;




}
