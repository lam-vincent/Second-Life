package com.example.depotsauvage.service;

import com.example.depotsauvage.model.User;
import com.example.depotsauvage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Method to save a new user
    public User createUser(User user) {
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("User already exists with username: " + user.getUsername());
        }

        user.setEmail(user.getEmail() != null ? user.getEmail() : "Default Email");
        user.setPassword(user.getPassword() != null ? user.getPassword() : "Default Password");
        user.setUsername(user.getUsername() != null ? user.getUsername() : "Default Username");

        return userRepository.save(user);
    }

    // Method to retrieve all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Method to retrieve a user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Method to retrieve a user by username
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // Method to update an existing user
    public User updateUser(Long id, User updatedUser) {
        // Retrieve the existing user from the database
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            // Update user properties
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
            // Save the updated user
            return userRepository.save(existingUser);
        } else {
            // Handle error (user not found)
            throw new IllegalArgumentException("User not found with id: " + id);
        }
    }

    // Method to delete a user by ID
    public void deleteUserById(Long id) {
        // Check if the user exists
        if (userRepository.existsById(id)) {
            // Delete the user
            userRepository.deleteById(id);
        } else {
            // Handle error (user not found)
            throw new IllegalArgumentException("User not found with id: " + id);
        }
    }
}
