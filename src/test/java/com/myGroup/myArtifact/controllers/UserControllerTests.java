package com.myGroup.myArtifact.controllers;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Tests the controller {@link UserController}.
 */
@SpringBootTest
public class UserControllerTests {

    @Autowired
    UserController userController;

    ////////////////////////////////////////////

    /**
     * Ensures the {@link UserController} is initialized.
     */
    @Test
    void userControllerNotNull() {
        assertThat(userController).isNotNull();
    }

}
