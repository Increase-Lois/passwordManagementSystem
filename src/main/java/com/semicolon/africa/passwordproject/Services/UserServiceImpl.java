package com.semicolon.africa.passwordproject.Services;

import com.semicolon.africa.passwordproject.Data.Models.User;
import com.semicolon.africa.passwordproject.Data.Repositories.UserRepository;
import com.semicolon.africa.passwordproject.Exceptions.UserApplicationException;
import com.semicolon.africa.passwordproject.dtos.requests.UserRequests.AccountRequest;
import com.semicolon.africa.passwordproject.dtos.requests.UserRequests.DeleteAccountRequest;
import com.semicolon.africa.passwordproject.dtos.requests.UserRequests.LoginRequest;
import com.semicolon.africa.passwordproject.dtos.requests.UserRequests.UpdateAccountRequest;
import com.semicolon.africa.passwordproject.dtos.responses.UserResponses.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public UserResponse createNewUserAccount(AccountRequest newRequest) {
        Optional<User> request = userRepository.findUserByEmailAddress(newRequest.getEmailAddress());
            if (request.isPresent()){
                throw new UserApplicationException("User with " + newRequest.getEmailAddress() + " already exists");
        }
        String emailAddress = newRequest.getEmailAddress();
        String username = newRequest.getUserName();
        String password = newRequest.getPassword();
        User user = new User(emailAddress,username,password);
        userRepository.save(user);
        UserResponse userResponse = new UserResponse();
        modelMapper.map(user, userResponse);
        return userResponse;
    }

    @Override
    public UserResponse findUserByEmailAddress(String emailAddress) {
        userRepository.findUserByEmailAddress(emailAddress).orElseThrow(()->
             new UserApplicationException("User with " + emailAddress + " does not exist"));

        UserResponse response = new UserResponse();
        modelMapper.map(emailAddress,response);
        return response;
    }

    @Override
    public String LogIn(LoginRequest loginRequest) {
        User user = userRepository.findUserByEmailAddress(loginRequest.getEmailAddress()).orElseThrow(()->
        new UserApplicationException("User with " + loginRequest.getEmailAddress() + " does not exist"));

        if (user.getPassword().equals(loginRequest.getPassword())){
            user.setLoggedIn(true);
            userRepository.save(user);
        }
        return "Successfully logged in";
    }

    @Override
    public String updateUserDetail(UpdateAccountRequest updateAccountRequest, String emailAddress) {
        User user = userRepository.findUserByEmailAddress(emailAddress)
                .orElseThrow(()->new UserApplicationException("User with " + emailAddress + "does not exist"));
        if (user.isLoggedIn()) {
            if (!(updateAccountRequest.getEmailAddress() == null || updateAccountRequest.getEmailAddress().trim().equals(""))) {
                user.setEmailAddress(updateAccountRequest.getEmailAddress());
            }
            if (!(updateAccountRequest.getUserName() == null || updateAccountRequest.getUserName().trim().equals(""))) {
                user.setUserName(updateAccountRequest.getUserName());
            }
            if (!(updateAccountRequest.getFirstName() == null || updateAccountRequest.getFirstName().trim().equals(""))) {
                user.setFirstName(updateAccountRequest.getFirstName());
            }
            if (!(updateAccountRequest.getLastName() == null || updateAccountRequest.getLastName().trim().equals(""))) {
                user.setLastName(updateAccountRequest.getLastName());
            }

                    userRepository.save(user);
        }
        else{
            throw new UserApplicationException(("User not logged in"));
        }
        return "Your details has been updated successfully";

    }

    @Override
    public String deleteUserAccount(DeleteAccountRequest deleteAccountRequest) {
        User user = userRepository.findUserByEmailAddress(deleteAccountRequest.)
        return null;
    }


}






