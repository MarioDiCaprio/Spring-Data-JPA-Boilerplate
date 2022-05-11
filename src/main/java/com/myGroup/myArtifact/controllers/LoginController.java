package com.myGroup.myArtifact.controllers;


import com.myGroup.myArtifact.controllers.request.LoginRequest;
import com.myGroup.myArtifact.controllers.response.LoginResponse;
import com.myGroup.myArtifact.entities.User;
import com.myGroup.myArtifact.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


/**
 * This controller handles the endpoint {@code /login}.
 */
@RestController
@RequestMapping("/login")
@SuppressWarnings("unused")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /////////////////////////////////////////////////////////

    /**
     * Handles the default endpoint. Each login attempt is made with a username
     * and a password. A login attempt is valid if the given data matches an
     * entry in the database and invalid if no matching entry was found.
     * <br>
     * <b>Note: Only accepts POST requests</b>
     * @param request The login request
     * @return The login response
     * @see LoginRequest
     * @see LoginResponse
     */
    @PostMapping
    public LoginResponse login(@RequestBody LoginRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();
        User user = userRepository.findByUsername(username).orElse(null);
        boolean valid = (user != null) && passwordEncoder.matches(password, user.getPassword());
        return new LoginResponse(username, password, valid);
    }

}
