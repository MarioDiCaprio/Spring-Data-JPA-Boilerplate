package com.myGroup.myArtifact.controllers.response;


import com.myGroup.myArtifact.controllers.LoginController;
import com.myGroup.myArtifact.controllers.request.LoginRequest;

/**
 * This class represents the response body of the endpoint {@code /login}.
 * Each login attempt has the following properties:
 * <ul>
 *     <li>The username of the attempted login</li>
 *     <li>The password of the attempted login</li>
 *     <li>Whether the login attempt was valid</li>
 * </ul>
 * @see LoginRequest
 * @see LoginController
 */
@SuppressWarnings("unused")
public class LoginResponse {

    private final String username;
    private final String password;
    private final boolean valid;

    /**
     * Creates a new login response.
     * @param username The username of the login attempt
     * @param password The password of the login attempt
     * @param valid Whether the login attempt was valid
     */
    public LoginResponse(String username, String password, boolean valid) {
        this.username = username;
        this.password = password;
        this.valid = valid;
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

    /**
     * Retrieves the validity of the login attempt.
     * @return Whether the login attempt was valid
     */
    public boolean isValid() {
        return valid;
    }

}
