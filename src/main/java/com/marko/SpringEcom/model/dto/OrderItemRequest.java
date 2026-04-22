package com.marko.SpringEcom.model.dto;

public record OrderItemRequest(
        int productId,
        int quantity
) {}
