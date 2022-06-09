package com.semicolon.africa.passwordproject.dtos.requests.UserRequests;


import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAccountRequest {
    private String userName;
    @NonNull
    private String password;
    @NonNull
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String phoneNumber;


    @Override
    public String toString() {
        return "UpdateAccountRequest{" +
                "userName='" + userName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
