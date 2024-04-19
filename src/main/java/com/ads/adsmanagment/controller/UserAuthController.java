package com.ads.adsmanagment.controller;

import com.ads.adsmanagment.service.UserService;
import com.ads.adsmanagment.util.JWTMgmtUtilityService;

import com.ads.adsmanagment.dto.request.UserAuthRequest;
import com.ads.adsmanagment.dto.response.UserAuthResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping(value = {"/adsweb/api/v1/patient/auth"})
public class UserAuthController {

    private JWTMgmtUtilityService jwtMgmtUtilityService;
    private AuthenticationManager authenticationManager;
    private UserService userService;


    public UserAuthController(JWTMgmtUtilityService jwtMgmtUtilityService,
                              AuthenticationManager authenticationManager,
                              UserService userService) {
        this.jwtMgmtUtilityService = jwtMgmtUtilityService;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }
    @PostMapping(value = {"/login"})
    public ResponseEntity<UserAuthResponse> authenticateUser(@Valid @RequestBody UserAuthRequest userAuthRequest) throws Exception {
        UserAuthResponse userAuthResponse = null;
        try {
            var username = userAuthRequest.username();
            var password = userAuthRequest.password();
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username,
                            password)
            );
            var jwtToken = jwtMgmtUtilityService.generateToken(username);
            var user = userService.getUserByUsername(username);
            if(user != null) {
                userAuthResponse = new UserAuthResponse(jwtToken, user.getFirstName(), user.getLastName());
            }
        } catch (Exception ex) {
            System.out.println("UserAuthException is: " + ex);
            throw ex;
        }
        return ResponseEntity.ok(userAuthResponse);
    }

}
