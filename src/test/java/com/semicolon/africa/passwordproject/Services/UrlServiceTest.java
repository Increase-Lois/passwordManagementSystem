package com.semicolon.africa.passwordproject.Services;


import com.semicolon.africa.passwordproject.Data.Repositories.UrlRepository;
import com.semicolon.africa.passwordproject.dtos.requests.UrlRequests.UrlRequest;
import com.semicolon.africa.passwordproject.dtos.requests.UserRequests.AccountRequest;
import com.semicolon.africa.passwordproject.dtos.requests.UserRequests.LoginRequest;
import com.semicolon.africa.passwordproject.dtos.responses.UrlResponses.UrlResponse;
import com.semicolon.africa.passwordproject.dtos.responses.UserResponses.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@Slf4j
public class UrlServiceTest {
    @Autowired
    UrlRepository urlRepository;

    @Autowired
    UrlService urlService;

    @Autowired
    UserService userService;

    UrlRequest request;

    AccountRequest accountRequest;

    @BeforeEach
    void setup() {
        request = UrlRequest.builder().userName("love").urlAddress("www.tweeter.com").password("#!Lois")
                .emailAddress("lois@gmail.com").build();

        accountRequest = AccountRequest.builder().emailAddress("lois@gmail.com").userName("Loys").password("amor").build();
    }


    @Test
    public void urlCanBeCreatedTest(){
//        UserResponse response1=userService.createNewUserAccount(accountRequest);
//        LoginRequest loginRequest = new LoginRequest();
//        loginRequest.setEmailAddress(response1.getEmailAddress());
//        loginRequest.setPassword("#!Lois");
//        userService.LogIn(loginRequest);
//        UrlResponse response = urlService.addNewUrl(request, "lois@gmail.com");
//        assertNotNull(response);
//        log.info("response is --->{}", response);
//        log.info("request is --->{}", request);
//        assertThat(response.getUserName(), is("love"));
//        assertThat(response.getUrlAddress(), is("www.tweeter.com"));

    }
//
//    @Test
//    void urlCanBeCreatedWhenRequiredFieldsAreFilledTest(){
//        UrlRequest newRequest= new UrlRequest("www.facebook.com","Adelove",
//                    "juwon_4", "miju@gmail.com" );
//        UrlResponse newresponse = urlService.createNewUrlAccount(newRequest);
//        assertNotNull(newresponse);
//        log.info("newresponse is --->{}", newresponse);
//        log.info("newRequest is --->{}", newRequest);
//        assertThat(newRequest.getEmailAddress(), is("miju@gmail.com"));
//        assertThat(newRequest.getUrlAddress(), is("www.facebook.com"));
//        assertThat(newRequest.getUsername(), is("Adelove"));
//        assertThat(newRequest.getPassword(), is("juwon_4"));
//    }
//
//    @Test
//    void urlCanBeFoundByUrlAddressTest(){
//        urlService.createNewUrlAccount(request);
//         urlService.findUrlByUserName("jose_watt");
//        assertNotNull(urlResponse);
//        assertThat(urlResponse.getUsername(), is("jose_watt"));


    }

