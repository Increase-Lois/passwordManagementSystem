package com.semicolon.africa.passwordproject.Services;


import com.semicolon.africa.passwordproject.Data.Repositories.UserRepository;
import com.semicolon.africa.passwordproject.Exceptions.PasswordApplicationException;
import com.semicolon.africa.passwordproject.Exceptions.UserApplicationException;
import com.semicolon.africa.passwordproject.dtos.requests.UserRequests.AccountRequest;
import com.semicolon.africa.passwordproject.dtos.requests.UserRequests.LoginRequest;
import com.semicolon.africa.passwordproject.dtos.requests.UserRequests.UpdateAccountRequest;
import com.semicolon.africa.passwordproject.dtos.responses.UserResponses.UserResponse;
import lombok.extern.slf4j.Slf4j;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Slf4j
class UserServiceImplTest {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    ModelMapper modelMapper = new ModelMapper();

    AccountRequest request;
    AccountRequest allRequest;
    AccountRequest firstAccountRequest;
    AccountRequest secondAccountRequest;
    AccountRequest thirdAccountRequest;

    AccountRequest request2;
    UpdateAccountRequest updateAccountRequest;

    @BeforeEach
    public void setUp(){
        request = AccountRequest.builder().emailAddress("lois@gmail.com").userName("Loys").password("amor").build();

        allRequest = AccountRequest.builder().emailAddress("teddybear@gmail.com").userName("Day_vid").password("dayveed**")
                                   .firstName("David").lastName("Ijeh").build();

        firstAccountRequest =
                AccountRequest.builder().userName("Ademiju").emailAddress("miju@gmail.com").password("juw&&!on").build();

        secondAccountRequest =
                AccountRequest.builder().userName("Ola").emailAddress("ola@gmail.com").password("olab_#anji").build();

//        thirdAccountRequest =
//                AccountRequest.builder().userName("Oke").emailAddress("praise@gmail.com").password("Okezua%%").build();

        request2 = AccountRequest.builder().userName("Ade").emailAddress("juwon@gmail.com").password("amigos").build();

    }
    @Test
    public void userCanBeCreatedTest() {
        UserResponse response = userService.createNewUserAccount(request);
        assertNotNull(response);
        assertThat(response.getUserName() ,is(request.getUserName()));
        assertThat(response.getEmailAddress(),is(request.getEmailAddress()));

    }

    @Test
    public void userCanOnlyBeCreatedWhenRequiredFieldAreFilledTests() {
        UserResponse response = userService.createNewUserAccount(allRequest);
        assertNotNull(response);
        assertThat(response.getUserName(), is(allRequest.getUserName()));
        assertThat(response.getEmailAddress(), is(allRequest.getEmailAddress()));
    }

    @Test
    public void multipleUsersCanBeAddedTest(){
        UserResponse response = userService.createNewUserAccount(firstAccountRequest);
        UserResponse response1 = userService.createNewUserAccount(secondAccountRequest);

        assertNotNull(response);
        assertNotNull(response1);

        assertThat(response.getUserName(),is(firstAccountRequest.getUserName()));
        assertThat(response.getEmailAddress(), is(firstAccountRequest.getEmailAddress()));
        assertThat(response1.getUserName(),is(secondAccountRequest.getUserName()));
        assertThat(response1.getEmailAddress(), is(secondAccountRequest.getEmailAddress()));

    }

    @Test
    public void findUserByEmailAddressTest(){
       UserResponse user = userService.createNewUserAccount(request2);
       UserResponse userResponse = userService.findUserByEmailAddress(request2.getEmailAddress());
       modelMapper.map(user,userResponse);
       assertNotNull(userResponse);
       assertThat(userResponse.getEmailAddress()).isEqualTo(user.getEmailAddress());
    }

    @Test
    public void userWithExistingEmailThrowsExceptionTest() {
        userService.createNewUserAccount(request2);
        assertThatThrownBy(() -> userService.createNewUserAccount(request2))
                                            .isInstanceOf(PasswordApplicationException.class)
                                            .hasMessage("User with "+ request2.getEmailAddress() +" already exists");

    }

    @Test
    public void checkIfUserIsLoggedInTest(){
        userService.createNewUserAccount(request);
        LoginRequest loginRequest = new LoginRequest(request.getEmailAddress(), request.getPassword());
        String response = userService.LogIn(loginRequest);
        assertThat(response, is("Successfully logged in"));

    }

    @Test
     void userCanUpdateDetailsTest() {

        userService.createNewUserAccount(request);
        userService.findUserByEmailAddress(request.getEmailAddress());

        LoginRequest loginRequest =new LoginRequest(request.getEmailAddress() ,request.getPassword());
        userService.LogIn(loginRequest);

        updateAccountRequest = UpdateAccountRequest.builder().emailAddress("increase@gmail.com").password("22654as").build();

        String response = userService.updateUserDetail(updateAccountRequest,"lois@gmail.com");
        log.info("updateAccountRequest--->{}",updateAccountRequest);
        assertEquals(response, "Your details has been updated successfully");
    }

    @Test
    public void userCanBeDeletedTest(){
        userService.createNewUserAccount(request);
        userService.deleteUserAccount("lois@gmail.com");
        assertThatThrownBy(()->userService.findUserByEmailAddress("lois@gmail.com"))
                .isInstanceOf(UserApplicationException.class)
                .hasMessage("User with " +request.getEmailAddress() + " does not exist");
    }

    @AfterEach
    void tearDown(){
        userRepository.deleteAll();
    }


}


    //userService.findUserByEmailAddress("lois@gmail.com");
//        assertThatThrownBy(()-> userService.findUserByEmailAddress("lois@gmail.com")).isInstanceOf(UserApplicationException.class)
//                .hasMessage("user with " + request.getEmailAddress() + " does not exist");
//        assertEquals(message, "Successfully logged in");
//        assertThat(updateAccountRequest.getUserName()).isEqualTo(userResponse.getUserName());