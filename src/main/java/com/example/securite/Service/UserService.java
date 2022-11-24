package com.example.securite.Service;

import com.example.securite.model.User;

import java.util.List;

import org.springframework.stereotype.Service;

@Service

public interface UserService {
    User getUser(String id);

    List<User> getAllUser();

    User addUser(User user);

    User updateUser(User user);

    void deleteUser (String id);
}
