package com.techwithfathi.bankapi.services;

import com.techwithfathi.bankapi.dto.user.UserRegisterRequestDto;
import com.techwithfathi.bankapi.exceptions.ApiException;
import com.techwithfathi.bankapi.models.User;
import com.techwithfathi.bankapi.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String registerUser(UserRegisterRequestDto userRegisterRequestDto) {
        Optional<User> user = userRepository.findByUsername(userRegisterRequestDto.getUsername());
        if (user.isPresent())
            throw new ApiException("User already exist");
        User newUser = new User();
        newUser.setUsername(userRegisterRequestDto.getUsername());
        newUser.setPassword(userRegisterRequestDto.getPassword());
        newUser.setDebt(0);
        newUser.setOwn(0);
        userRepository.save(newUser);
        return "You Successfully registered for the API";
    }
}
