package com.myGroup.myArtifact.repositories;


import com.myGroup.myArtifact.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


/**
 * This is a JPA repository for the {@link User} entity.
 * @see User
 * @see JpaRepository
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    /**
     * Finds a user by their username.
     * @param username The user's username
     * @return The potential user
     */
    Optional<User> findByUsername(String username);

    /**
     * Finds a user by their username and their password. This is
     * useful for checking login validity.
     * @param username The user's username
     * @param password The user's password
     * @return The potential user
     */
    Optional<User> findByUsernameAndPassword(String username, String password);

    /**
     * Finds users by a given email.
     * @param email The email to search users for
     * @return A list of all users with the given email
     */
    List<User> findByEmail(String email);

    /**
     * Checks whether a user with a given username exists.
     * @param username The user's username
     * @return Whether such a user exists
     */
    boolean existsByUsername(String username);

}
