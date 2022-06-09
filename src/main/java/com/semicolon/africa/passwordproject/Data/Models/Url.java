package com.semicolon.africa.passwordproject.Data.Models;

import lombok.*;


import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@RequiredArgsConstructor
@NoArgsConstructor
public class Url {
    @NonNull
    private String urlAddress;
    @NonNull
    private String userName;
    @NonNull
    private String password;


//    todo remove first n last name n email n urlowner



//
//    public Url(@NonNull String urlAddress, @NonNull String username, @NonNull String password, @NonNull String emailAddress) {
//        this.urlAddress = urlAddress;
//        this.username = username;
//
//    }
}
