package com.semicolon.africa.passwordproject.Data.Models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
@RequiredArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    @NonNull
    private String emailAddress;
    @NonNull
    private String userName;
    @NonNull
    private String password;
    private boolean isLoggedIn;
    private List<Url> urls;
}
