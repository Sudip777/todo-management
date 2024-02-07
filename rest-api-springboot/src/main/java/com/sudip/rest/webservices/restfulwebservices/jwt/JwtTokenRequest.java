package com.sudip.rest.webservices.restfulwebservices.jwt;

/**
 * Represents a JWT token request.
 */
public record JwtTokenRequest(String username, String password) {}