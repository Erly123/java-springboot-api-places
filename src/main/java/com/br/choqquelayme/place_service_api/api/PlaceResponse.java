package com.br.choqquelayme.place_service_api.api;

import java.time.LocalDateTime;

public record PlaceResponse(String name, String slug, String state, LocalDateTime createdAt, LocalDateTime updatedAt
        ) {
} 