package com.myGroup.myArtifact.controllers;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Tests the controller {@link RegisterController}.
 */
@SpringBootTest
public class RegisterControllerTests {

    @Autowired
    RegisterController registerController;

    /////////////////////////////////////////////////////

    /**
     * Ensures the {@link RegisterController} is initialized.
     */
    @Test
    void registerControllerNotNull() {
        assertThat(registerController).isNotNull();
    }

}
