package com.myGroup.myArtifact.controllers.response;


import com.myGroup.myArtifact.controllers.RegisterController;
import com.myGroup.myArtifact.controllers.request.RegisterRequest;

/**
 * This class represents the response body of the endpoint {@code /register}.
 * Each registration attempt has the following properties:
 * <ul>
 *     <li>The username of the attempted registration</li>
 *     <li>The email of the attempted registration</li>
 *     <li>The password of the attempted registration</li>
 *     <li>Whether the registration attempt was valid</li>
 * </ul>
 * @see RegisterRequest
 * @see RegisterController
 */
public class RegisterResponse {

    private final String username;
    private final String email;
    private final String password;
    private final boolean valid;

    /**
     * Creates a new registration response.
     * @param username The username of the registration attempt
     * @param email The email of the registration attempt
     * @param password The password of the registration attempt
     * @param valid Whether the registration attempt was valid
     */
    public RegisterResponse(String username, String email, String password, boolean valid) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.valid = valid;
    }

    /**
     * Retrieves the registration's username.
     * @return The username of the registration attempt
     */
    public String getUsername() {
        return username;
    }

    /**
     * Retrieves the registration's email.
     * @return The email of the registration attempt
     */
    public String getEmail() {
        return email;
    }

    /**
     * Retrieves the password of the registration.
     * @return The password of the registration attempt.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Retrieves the validity of the registration attempt.
     * @return Whether the registration attempt was valid
     */
    public boolean isValid() {
        return valid;
    }

}
