package com.example.homes.service;

import com.example.homes.model.User;
import com.example.homes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Value("${admin.key}")
    private String adminKey;  // This will inject the value from application.properties

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(User user, String providedAdminKey) {
        // If the user is registering as Admin, validate the admin key
        if ("ADMIN".equalsIgnoreCase(user.getRole())) {
            if (providedAdminKey == null || !providedAdminKey.equals(adminKey)) {
                throw new IllegalArgumentException("Invalid Admin Key! You must provide the correct admin key to register as an admin.");
            }
        }
        userRepository.save(user);  // Save the user to the repository
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
