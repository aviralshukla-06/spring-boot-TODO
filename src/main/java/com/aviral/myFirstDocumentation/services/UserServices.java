package com.aviral.myFirstDocumentation.services;

import com.aviral.myFirstDocumentation.models.User;
import com.aviral.myFirstDocumentation.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServices {
    private final UserRepository userRepository;

    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new RuntimeException("Email already exists!");
        }
        return userRepository.save(user);
    }

    public User loginUser(User user) {
        User existingUser = userRepository.findByEmail(user.getEmail())
                .orElseThrow(()-> new RuntimeException("Email does not exist!"));


        if(!existingUser.getPassword().equals(user.getPassword())){
            throw new RuntimeException("Incorrect password!");
        }
        return existingUser;
    }
}
