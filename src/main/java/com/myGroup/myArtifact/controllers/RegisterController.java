package com.myGroup.myArtifact.controllers;


import com.myGroup.myArtifact.controllers.request.RegisterRequest;
import com.myGroup.myArtifact.controllers.response.RegisterResponse;
import com.myGroup.myArtifact.entities.User;
import com.myGroup.myArtifact.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


/**
 * This controller handles the endpoint {@code /register}.
 */
@RestController
@RequestMapping("/register")
@SuppressWarnings("unused")
public class RegisterController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //////////////////////////////////////////////////////////////

    /**
     * Handles the default endpoint. Each registration attempt is made with a username
     * and a password. A registration attempt is valid if the database contains no
     * entries with the given username and invalid if the username already exists.
     * <br>
     * <b>Note: Only accepts POST requests</b>
     * @param request The registration request
     * @return The registration response
     * @see RegisterRequest
     * @see RegisterResponse
     */
    @PostMapping
    public RegisterResponse register(@RequestBody RegisterRequest request) {
        String username = request.getUsername();
        String email = request.getEmail();
        String password = request.getPassword();
        boolean doesUsernameExist = userRepository.existsByUsername(username);
        // registration invalid if username already exists
        if (doesUsernameExist)
            return new RegisterResponse(username, email, password, false);
        // save new user to database
        User user = new User(username, email, passwordEncoder.encode(password));
        userRepository.save(user);
        // return response
        return new RegisterResponse(username, email, password, true);
    }

}
