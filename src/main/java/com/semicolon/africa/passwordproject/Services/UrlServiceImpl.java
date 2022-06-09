package com.semicolon.africa.passwordproject.Services;

import com.semicolon.africa.passwordproject.Data.Models.Url;
import com.semicolon.africa.passwordproject.Data.Models.User;
import com.semicolon.africa.passwordproject.Data.Repositories.UrlRepository;
import com.semicolon.africa.passwordproject.Data.Repositories.UserRepository;
import com.semicolon.africa.passwordproject.Exceptions.PasswordApplicationException;
import com.semicolon.africa.passwordproject.dtos.requests.UrlRequests.DeleteUrlRequest;
import com.semicolon.africa.passwordproject.dtos.requests.UrlRequests.UrlRequest;
import com.semicolon.africa.passwordproject.dtos.responses.UrlResponses.UrlResponse;

import com.semicolon.africa.passwordproject.dtos.responses.UserResponses.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UrlServiceImpl implements UrlService{

    @Autowired
    UrlRepository urlRepository;

    @Autowired
    UserService userService;

    @Autowired
     UserRepository userRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public UrlResponse addNewUrl(UrlRequest request, String emailAddress) {
        User user = userRepository.findUserByEmailAddress(emailAddress).orElseThrow(()->
                new PasswordApplicationException("user with " + emailAddress + " does not exist"));

        if(user.isLoggedIn()){
            Url url = new Url();
            url.setUrlAddress(request.getUrlAddress());
            url.setPassword(request.getPassword());
            url.setUserName(request.getUserName());
           Url savedUrl= urlRepository.save(url);
           user.getUrls().add(savedUrl);
           userRepository.save(user);
//            modelMapper.map(user, url);
           UrlResponse response = new UrlResponse();
           response.setUrlAddress(savedUrl.getUrlAddress());
           response.setUserName(savedUrl.getUserName());



//            modelMapper.map(user, userResponse);
//            urlRepository.save(url);
//            UrlResponse urlResponse = new UrlResponse();
//            modelMapper.map(url, urlResponse);
//            user.getUrls().add(url);
//            userRepository.save(user);
            return response;
//            return url;
        }
        else throw new PasswordApplicationException("You are not logged in");
    }

    @Override
    public Url findUrlByUrlAddress(String urlAddress) {
        urlRepository.findUrlByUrlAddress(urlAddress).orElseThrow(()->
                new PasswordApplicationException("Url does not exist"));
        Url url = new Url();
        modelMapper.map(urlAddress,url);
        return url;
    }

    @Override
    public UrlResponse findUrlByUserName(String username) {
        return null;
    }

    @Override
    public List<UrlResponse> findAllUrls() {
        return null;
    }

    @Override
    public void deleteUrl(DeleteUrlRequest deleteRequest) {

    }


//    @Override
//    public UrlResponse createNewUrl(UrlRequest request, String username) {
//
//        Optional<Url> optionalUser = userRepository.findUserByUserName(newRequest.getUserName());
//        if (optionalUser.isPresent()) throw new PasswordApplicationException("User already exists");
//
//        Optional<Url> optionalUserEmail = userRepository.findUserByEmailAddress(newRequest.getEmailAddress());
//        if(optionalUserEmail.isPresent()) throw new PasswordApplicationException("Email already exists!");
//
//        String username = request.getUsername();
//        String password = request.getPassword();
//        String urlAddress = request.getUrlAddress();
//        String emailAddress = request.getEmailAddress();
//        Url url = new Url(username,password,urlAddress,emailAddress);
//        urlRepository.save(url);
//        UrlResponse urlResponse = new UrlResponse();
//        modelMapper.map(url, urlResponse);
//        return urlResponse;
//       }

//    @Override
//    public UrlResponse findUrlByUrlAddress(String urlAddress) {
//        urlRepository.findUrlByUrlAddress(urlAddress).orElseThrow(()->
//                new PasswordApplicationException("url with " + urlAddress + "exists"));
//        UrlResponse urlResponse = new UrlResponse();
//        modelMapper.map(urlAddress,urlResponse);
//        return urlResponse;
//    }
//
//    @Override
//    public UrlResponse findUrlByUserName(String username) {
//        urlRepository.findUrlByUsername(username).orElseThrow(()-> new PasswordApplicationException("url with " + username +
//                "does not exist"));
//        UrlResponse urlResponse = new UrlResponse();
////        Url url = new Url();
////        urlRepository.save(username);
//        modelMapper.map(username,urlResponse);
////        return url;
//        return urlResponse;
////        urlRepository.save(urlResponse);
////        return urlResponse;
//    }

//    @Override
//    public UrlResponse findUrlByUsername(String username) {
//        urlRepository.findUrlByUsername(username)
//        if (optionalUrl.isPresent())
//            throw new PasswordApplicationException("user with" + username + "exists!");
//        urlRepository.findUrlByUrlAddress(urlAddress)).(()->
//                new PasswordApplicationException("url does not exist"));
//        UrlResponse urlResponse = new UrlResponse();
//        modelMapper.map(urlAddress, urlResponse);
//        return urlResponse;



//        public User findUserByUsername(String username) {
//            userRepository.findUserByUserName(username)
//                    .orElseThrow(()-> new PasswordApplicationException("User with username does not exist"));
//            User user = new User();
//            modelMapper.map(username,user);
//            return user;

//
//    @Override
//    public List<UrlResponse> findAllUrls() {
//        return null;
//    }
//
//    @Override
//    public void deleteUrl(DeleteUrlRequest deleteRequest) {
//
//    }
}
