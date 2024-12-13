package com.example.homes.service;

import com.example.homes.model.User;
import java.util.List;

public interface UserService {
    User findByUsername(String username);
    void saveUser(User user, String providedAdminKey);
    List<User> findAllUsers();
    void deleteUserById(Long id);
}
