package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    public UserDto getByLogin(String login) {
        User user = userRepository.findByLogin(login).orElse(null);
        return user != null ? UserDto.builder()
                .id(user.getId())
                .login(user.getLogin())
                .password(user.getPassword())
                .role(Role.valueOf(user.getRole()))
                .build() : null;
    }

    public List<UserDto> findAllUser() {
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            userDtoList.add(UserDto.builder()
                    .id(user.getId())
                    .login(user.getLogin())
                    .password(user.getPassword())
                    .role(Role.valueOf(user.getRole()))
                    .build());
        }
        return userDtoList;
    }

    public boolean existByLoginUser(String login) {
        return userRepository.existsByLogin(login);
    }

    public void saveUser(UserDto userDto) {
        String encode = encoder.encode(userDto.getPassword());
        User user = User.builder()
                .login(userDto.getLogin())
                .role(Role.USER.name())
                .password(encode)
                .build();
        userRepository.save(user);
    }
}
