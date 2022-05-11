package com.myGroup.myArtifact;


import com.myGroup.myArtifact.controllers.request.LoginRequest;
import com.myGroup.myArtifact.controllers.request.RegisterRequest;
import com.myGroup.myArtifact.controllers.response.LoginResponse;
import com.myGroup.myArtifact.controllers.response.RegisterResponse;
import com.myGroup.myArtifact.entities.User;
import com.myGroup.myArtifact.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Tests the REST Api. Tests each endpoint one-by-one.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback
@Transactional
public class HttpRequestTests {

    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    /////////////////////////////////////////////////////////////////

    String url(String url) {
        return "http://localhost:" + port + url;
    }

    /////////////////////////////////////////////////////////////////

    /**
     * Ensures the {@link TestRestTemplate} was initialized.
     */
    @Test
    void restTemplateNotNull() {
        assertThat(restTemplate).isNotNull();
    }

    /**
     * Ensures the {@link UserRepository} was initialized.
     */
    @Test
    void userRepositoryNotNull() {
        assertThat(userRepository).isNotNull();
    }

    /**
     * Ensures the {@link PasswordEncoder} was initialized.
     */
    @Test
    void passwordEncoderNotNull() {
        assertThat(passwordEncoder).isNotNull();
    }

    /**
     * Tests the endpoint {@code /login}.
     */
    @Test
    void login() {
        // create user first
        User user = new User("Hello", "helloworld@gmail.com", passwordEncoder.encode("World"));
        userRepository.save(user);

        // send valid login request
        String url = url("/login");
        LoginRequest request = new LoginRequest("Hello", "World");
        LoginResponse response = restTemplate.postForObject(url, request, LoginResponse.class);

        // assert login successful
        assertThat(response.isValid()).isTrue();

        // send invalid login request
        request = new LoginRequest("World", "Hello");
        response = restTemplate.postForObject(url, request, LoginResponse.class);

        // assert login failed
        assertThat(response.isValid()).isFalse();
    }

    /**
     * Tests the endpoint {@code /register}.
     */
    @Test
    void register() {
        // send request
        String url = url("/register");
        RegisterRequest request = new RegisterRequest("Hello", "helloworld@test.com", "World");
        RegisterResponse register = restTemplate.postForObject(url, request, RegisterResponse.class);

        // assert registration successful
        assertThat(register.isValid()).isTrue();

        // resend same registration
        register = restTemplate.postForObject(url, request, RegisterResponse.class);

        // assert failed, because username already exists
        assertThat(register.isValid()).isFalse();

        // assert password was encoded successfully
        User user = userRepository.findByUsername("Hello").orElse(null);
        assertThat(user).isNotNull();
        assertThat(user.getPassword()).isNotEqualTo("World");
    }

    /**
     * Tests the endpoint {@code /user}.
     */
    @Test
    void user() {
        // create user first
        User user = new User("Hello", "helloworld@gmail.com", "World");
        userRepository.save(user);

        // send request
        String url = url("/user");
        int numberOfUsers = restTemplate.getForObject(url, List.class).size();

        // assert number of users == 1
        assertThat(numberOfUsers).isEqualTo(1);
    }

    /**
     * Tests the endpoint {@code /user/byUsername}.
     */
    @Test
    void userByUsername() {
        // create user first
        User user = new User("Hello", "helloworld@gmail.com", "World");
        userRepository.save(user);

        // assert user was actually created
        int numberOfUsers = userRepository.findAll().size();
        assertThat(numberOfUsers).isEqualTo(1);

        // test endpoint
        String url = url("/user/byUsername");
        Map<String, String> data = Map.of("username", "Hello");
        User tmp = restTemplate.getForObject(url, User.class, data);

        // assert user was found
        assertThat(tmp).isNotNull();
    }

}
