package com.myGroup.myArtifact.entities;


import com.myGroup.myArtifact.controllers.UserController;
import com.myGroup.myArtifact.repositories.UserRepository;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;


/**
 * This class represents a user. Each user has the following properties:
 * <ul>
 *     <li>A User-ID (auto generated, unique)</li>
 *     <li>A Version (auto generated)</li>
 *     <li>A username (unique)</li>
 *     <li>An email</li>
 *     <li>A password</li>
 *     <li>A first name</li>
 *     <li>A last name</li>
 *     <li>A description</li>
 * </ul>
 * @see UserRepository
 * @see UserController
 */
@Entity
@SuppressWarnings("unused")
public class User {

    /**
     * Creates a user with no data set.
     */
    public User() { }

    /**
     * Creates a user with basic registration data.
     * @param username The user's username
     * @param email The user's email
     * @param password The user's password
     */
    public User(String username, String email, String password) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    /////////////////////////////////////////////////////////

    @Id
    @GeneratedValue
    private UUID userId;

    /**
     * Retrieves the user's ID.
     * @return The user's ID
     */
    public UUID getUserId() {
        return userId;
    }

    /**
     * Sets the user's ID.
     * @param userId The user's ID
     */
    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    /////////////////////////////////////////////////////////

    @Version
    @GeneratedValue
    private long userVersion;

    /**
     * Retrieves the user's version.
     * @return The user's version
     */
    public long getUserVersion() {
        return userVersion;
    }

    /**
     * Sets the user's version.
     * @param userVersion The user's version
     */
    public void setUserVersion(long userVersion) {
        this.userVersion = userVersion;
    }

    /////////////////////////////////////////////////////////

    @Column(unique = true)
    private String username;

    /**
     * Retrieves the user's username.
     * @return The user's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the user's username.
     * @param username The user's username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /////////////////////////////////////////////////////////

    @Column
    private String password;

    /**
     * Retrieves the user's password.
     * @return The user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user's password.
     * @param password The user's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /////////////////////////////////////////////////////////

    @Column
    private String email;

    /**
     * Retrieves the user's email.
     * @return The user's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email.
     * @param email The user's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /////////////////////////////////////////////////////////

    @Column
    private String firstName;

    /**
     * Retrieves the user's first name.
     * @return The user's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the user's first name.
     * @param firstName The user's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /////////////////////////////////////////////////////////

    @Column
    private String lastName;

    /**
     * Retrieves the user's last name.
     * @return The user's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the user's last name.
     * @param lastName The user's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /////////////////////////////////////////////////////////

    @Column
    @Lob
    private String description;

    /**
     * Retrieves the user's description.
     * @return The user's description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the user's description.
     * @param description The user's description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /////////////////////////////////////////////////////////


    /**
     * Checks if this user is equal to the given object. Returns {@code false}
     * if the given object is not an instance of {@link User}. Otherwise, returns
     * whether this user's ID matches the given user's ID (regardless of other fields).
     * @param o The object to compare to this user
     * @return Whether the two objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    /**
     * Hashes this user's ID. Delegates to {@code Objects.hash(userId)}.
     * @return The hashed user ID
     */
    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    /**
     * Converts this object to a {@code String}. Displayed fields are the
     * username and the user's ID.
     * @return This user as a {@code String}
     */
    @Override
    public String toString() {
        return "User{" +
                "userVersion=" + userVersion +
                ", username='" + username + '\'' +
                '}';
    }

}
