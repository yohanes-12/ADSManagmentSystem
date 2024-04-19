package com.ads.adsmanagment.service;


import com.ads.adsmanagment.model.User;

public interface UserService {

    User getUserByUsername(String username);

    User registerNewUser(User user);
}
