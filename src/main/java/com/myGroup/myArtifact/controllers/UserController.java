package com.myGroup.myArtifact.controllers;


import com.myGroup.myArtifact.entities.User;
import com.myGroup.myArtifact.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * This controller handles the endpoint {@code /user}.
 */
@RestController
@RequestMapping("/user")
@SuppressWarnings("unused")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    ////////////////////////////////////////////////////////////

    /**
     * Handles the default endpoint. Fetches all users in the
     * database.
     * <br>
     * <b>Note: Only accepts GET requests</b>
     * @return A list of all users in the database
     * @see User
     */
    @GetMapping
    public List<User> all() {
        return userRepository.findAll();
    }

    /**
     * Handles the endpoint {@code /user/byUsername}. Finds a user by
     * their username.
     * <br>
     * <b>Note: Only accepts GET requests</b>
     * @param username The user's username
     * @return The user, or {@code null} if no match was found
     * @see User
     */
    @GetMapping("/byUsername")
    public User byUsername(@RequestParam String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

}
