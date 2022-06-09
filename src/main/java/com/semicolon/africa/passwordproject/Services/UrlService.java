package com.semicolon.africa.passwordproject.Services;


import com.semicolon.africa.passwordproject.Data.Models.Url;
import com.semicolon.africa.passwordproject.dtos.requests.UrlRequests.DeleteUrlRequest;
import com.semicolon.africa.passwordproject.dtos.requests.UrlRequests.UrlRequest;
import com.semicolon.africa.passwordproject.dtos.responses.UrlResponses.UrlResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UrlService {
    UrlResponse addNewUrl(UrlRequest request, String emailAddress);
    Url findUrlByUrlAddress(String urlAddress);
    UrlResponse findUrlByUserName(String username);
    List<UrlResponse> findAllUrls();
    void deleteUrl(DeleteUrlRequest deleteRequest);

}

//    @Override
//    public UrlResponse addNewUrl(UrlRequest request, String userName) {
//        User user = userRepository.findUserByUserName(userName).orElseThrow(()->new PasswordApplicationException("User not found!"));
//        Url url = new Url();
//        modelMapper.map(request,url);
//        url.setUrlOwner(user);
//        urlRepository.save(url);
//        UrlResponse urlResponse = new UrlResponse();
//        modelMapper.map(url,urlResponse);
//        return urlResponse;
//
//
//    }



//    @Override
//    public Url findUrlByUserName(String username) {
//        User user = new User();
//        userRepository.findUserByUserName(username).orElseThrow(()->new PasswordApplicationException("User not found!"));
//        Url url = new Url();
//         modelMapper.map(username,url);
//        modelMapper.map(user,url);
//        url.setUrlOwner(user);
//        urlRepository.save(url);
//        UrlResponse urlResponse = new UrlResponse();
//        modelMapper.map(url,urlResponse);
//        return urlResponse;
//        return urlRepository.findUrlByUsername(userName);
//    }


//@Test
//    public void userCanFindUrlByUserNameTest(){
//        AccountRequest request = AccountRequest.builder().userName("Lois").password("amor").emailAddress("lois@gmail.com").build();
//        UserResponse response = userService.createNewUserAccount(request);
//
//        UrlRequest request1 = UrlRequest.builder().urlAddress("www.tweeter.com").username("Lois").password("amor").emailAddress("lois@gmail.com").build();
//        UrlRequest request2 = UrlRequest.builder().urlAddress("www.freepik.com").username("Lois").password("amor").emailAddress("lois@gmail.com").build();
//        UrlRequest request3 = UrlRequest.builder().urlAddress("www.hinstargram.com").username("Lois").password("amor").emailAddress("lois@gmail.com").build();
//
//        User user = new User();
//        modelMapper.map(response,user);
//
////        UrlResponse response1 = userService.findUrlByUserName("Lois");
//        UrlResponse response1 = userService.addNewUrl(request1,user.getUserName());
//        UrlResponse response2 = userService.addNewUrl(request2,user.getUserName());
//        UrlResponse response3 = userService.addNewUrl(request3,user.getUserName());
//       Url url = new Url();
//       modelMapper.map(response1, url);
//       assertNotNull(url);
//    assertThat(url.getEmailAddress(), is("lois@gmail.com"));
//       assertThat(url.getUrlOwner(), is("lois"));
//
//         url = userService.findUrlByUserName("Lois");
//
//        assertNotNull(urls);
//        assertThat(urls.size(), is(2));

//    @Test
//    public void userCanAddUrlAddressTest() {
//        AccountRequest newRequest = AccountRequest.builder().userName("Ademiju").password("juwon#").emailAddress("juwon@gmail.com").build();
//        UserResponse userResponse = userService.createNewUserAccount(newRequest);
//        User user = new User();
//        modelMapper.map(userResponse, user);
//        UrlRequest request = UrlRequest.builder().urlAddress("www.tweeter.com").username("Ademiju").password("juwon#").emailAddress("juwon@gmail.com").build();
//        UrlResponse urlResponse = userService.addNewUrl(request, user.getUserName());
//        Url newUrl = new Url();
//        modelMapper.map(urlResponse, newUrl);
//        assertNotNull(newUrl);
//        assertThat(user.getUserName(), is("Ademiju"));
//        assertThat(newUrl.getEmailAddress(), is("juwon@gmail.com"));
//    }
//
//