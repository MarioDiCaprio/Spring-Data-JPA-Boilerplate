package com.myGroup.myArtifact.repositories;


import com.myGroup.myArtifact.entities.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Tests the {@link UserRepository}. Ensures the Api methods
 * work properly.
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback
public class UserRepositoryTests {

    @Autowired
    UserRepository userRepository;

    //////////////////////////////////////////////////////

    /**
     * Ensures the {@link UserRepository} was initialized.
     */
    @Test
    void userRepositoryNotNull() {
        assertThat(userRepository).isNotNull();
    }

    /**
     * Tests the {@code UserRepository#save()} method.
     */
    @Test
    void save() {
        // create user
        User user = new User("Hello", "helloworld@gmail.com", "World");
        userRepository.save(user);
        // assert user was saved successfully
        assertThat(user.getUserId()).isNotNull();
    }

    /**
     * Tests the {@code UserRepository#findById()} method.
     */
    @Test
    void findById() {
        // create user first
        User user = new User("Hello", "helloworld@gmail.com", "World");
        userRepository.save(user);
        // assert user can be found successfully
        User tmp = userRepository.findById(user.getUserId()).orElse(null);
        assertThat(tmp).isNotNull();
    }

    /**
     * Tests the {@code UserRepository#findByUsername()} method.
     */
    @Test
    void findByUsername() {
        // create user first
        User user = new User("Hello", "helloworld@gmail.com", "World");
        user.setUsername("Hello");
        userRepository.save(user);
        // assert user can be found successfully
        User tmp = userRepository.findByUsername(user.getUsername()).orElse(null);
        assertThat(tmp).isNotNull();
    }

    /**
     * Tests the {@code UserRepository#findByEmail()} method.
     */
    @Test
    void findByEmail() {
        // create user first
        User user = new User("Hello", "helloworld@gmail.com", "World");
        userRepository.save(user);
        // assert user can be found successfully
        int tmp = userRepository.findByEmail(user.getEmail()).size();
        assertThat(tmp).isGreaterThan(0);
    }

    /**
     * Tests the {@code UserRepository#existsByUsername()} method.
     */
    @Test
    void existsByUsername() {
        // create user first
        User user = new User("Hello", "helloworld@gmail.com", "World");
        userRepository.save(user);
        // assert user exists
        assertThat(userRepository.existsByUsername("Hello")).isTrue();
    }

    /**
     * Tests the {@code UserRepository#save()} method to update a user.
     */
    @Test
    void update() {
        // create user first
        User user = new User("Hello", "helloworld@gmail.com", "World");
        userRepository.save(user);
        // update user field
        user.setUsername("Hello");
        userRepository.save(user);
        // assert username was updated
        User tmp = userRepository.findById(user.getUserId()).orElse(null);
        String username = (tmp == null)? null : tmp.getUsername();
        assertThat(username).isEqualTo("Hello");
    }

    /**
     * Tests the {@code UserRepository#delete()} method.
     */
    @Test
    void delete() {
        // create user first
        User user = new User("Hello", "helloworld@gmail.com", "World");
        userRepository.save(user);
        // delete user
        userRepository.delete(user);
        // assert user cannot be found anymore
        User tmp = userRepository.findById(user.getUserId()).orElse(null);
        Assertions.assertThat(tmp).isEqualTo(null);
    }

}
