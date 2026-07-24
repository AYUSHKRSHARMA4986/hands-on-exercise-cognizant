package com.cognizant.springlearn.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    // Generate a secure, randomized signing key for the JWT in memory
    private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start authenticate");

        // ---------------------------------------------------------
        // STEP 2: Read Authorization header and decode the username
        // ---------------------------------------------------------
        // The header arrives looking like: "Basic dXNlcjpwd2Q="
        // We strip the word "Basic " to isolate the Base64 string
        String base64Credentials = authHeader.substring("Basic".length()).trim();

        // Decode the Base64 string into plain text
        byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
        String credentials = new String(credDecoded, StandardCharsets.UTF_8);

        // The plain text format is "username:password". We split it to get the username.
        final String[] values = credentials.split(":", 2);
        String user = values[0];
        LOGGER.debug("Successfully decoded user: {}", user);

        // ---------------------------------------------------------
        // STEP 3: Generate token based on the user retrieved
        // ---------------------------------------------------------
        String token = generateJwtToken(user);

        // Returning a Map automatically converts into JSON format: {"token": "..."}
        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        LOGGER.info("End authenticate");
        return response;
    }

    private String generateJwtToken(String username) {
        long expirationTime = 1000 * 60 * 60; // Set token to expire in 1 hour
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(secretKey)
                .compact();
    }
}