package com.myGroup.myArtifact.controllers.request;


import com.myGroup.myArtifact.controllers.RegisterController;
import com.myGroup.myArtifact.controllers.response.RegisterResponse;

/**
 * This class represents the response body of the endpoint {@code /register}.
 * Each registration attempt has the following properties:
 * <ul>
 *     <li>The username of the attempted registration</li>
 *     <li>The email of the attempted registration</li>
 *     <li>The password of the attempted registration</li>
 *     <li>Whether the registration attempt was valid</li>
 * </ul>
 * @see RegisterResponse
 * @see RegisterController
 */
@SuppressWarnings("unused")
public class RegisterRequest {

    private final String username;
    private final String email;
    private final String password;

    /**
     * Creates a new registration request.
     * @param username The username of the registration attempt
     * @param email The email of the registration attempt
     * @param password The password of the registration attempt
     */
    public RegisterRequest(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
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

}
