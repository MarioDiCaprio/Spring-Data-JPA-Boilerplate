package com.myGroup.myArtifact.controllers.request;


import com.myGroup.myArtifact.controllers.LoginController;
import com.myGroup.myArtifact.controllers.response.LoginResponse;

/**
 * This class represents the request body of the endpoint {@code /login}.
 * Each login attempt has the following properties:
 * <ul>
 *     <li>The username of the attempted login</li>
 *     <li>The password of the attempted login</li>
 * </ul>
 * @see LoginResponse
 * @see LoginController
 */
@SuppressWarnings("unused")
public class LoginRequest {

    private final String username;
    private final String password;

    /**
     * Creates a new login request.
     * @param username The username of the login attempt
     * @param password The password of the login attempt
     */
    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Retrieves the login's username.
     * @return The username of the login attempt
     */
    public String getUsername() {
        return username;
    }

    /**
     * Retrieves the password of the login.
     * @return The password of the login attempt.
     */
    public String getPassword() {
        return password;
    }

}
