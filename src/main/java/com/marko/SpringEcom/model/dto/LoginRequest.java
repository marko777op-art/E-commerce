package com.marko.SpringEcom.model.dto;

public record LoginRequest(
        String email,
        String password
) {}