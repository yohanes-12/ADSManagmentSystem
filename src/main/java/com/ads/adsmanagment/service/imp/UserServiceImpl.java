package com.ads.adsmanagment.service.imp;

import com.ads.adsmanagment.model.User;
import com.ads.adsmanagment.repository.UserRepository;
import com.ads.adsmanagment.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username)
                .orElse(null);
    }

    @Override
    public User registerNewUser(User user) {
        return null;
    }
}
