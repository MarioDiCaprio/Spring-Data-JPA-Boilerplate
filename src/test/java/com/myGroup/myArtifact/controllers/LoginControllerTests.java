package com.myGroup.myArtifact.controllers;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Tests the controller {@link LoginController}.
 */
@SpringBootTest
public class LoginControllerTests {

    @Autowired
    LoginController loginController;

    ///////////////////////////////////////////////////////

    /**
     * Ensures the {@link LoginController} is initialized.
     */
    @Test
    void loginControllerNotNull() {
        assertThat(loginController).isNotNull();
    }

}
