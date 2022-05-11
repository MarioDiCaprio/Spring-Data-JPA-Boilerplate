package com.myGroup.myArtifact;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * This is the main {@code @SpringBootApplication} class.
 */
@SpringBootApplication
public class MyApplication {

	/**
	 * Starts the server on the configured address.
	 * @param args The arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}

}
