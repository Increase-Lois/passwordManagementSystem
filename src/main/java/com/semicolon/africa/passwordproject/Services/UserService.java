package com.semicolon.africa.passwordproject.Services;


import com.semicolon.africa.passwordproject.dtos.requests.UserRequests.AccountRequest;
import com.semicolon.africa.passwordproject.dtos.requests.UserRequests.LoginRequest;
import com.semicolon.africa.passwordproject.dtos.requests.UserRequests.UpdateAccountRequest;
import com.semicolon.africa.passwordproject.dtos.responses.UserResponses.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserResponse createNewUserAccount(AccountRequest newRequest);
    UserResponse findUserByEmailAddress(String emailAddress);
    String LogIn(LoginRequest emailAddress);
    String updateUserDetail(UpdateAccountRequest updateAccountRequest, String emailAddress);
    void deleteUserAccount(String emailAddress);
}
