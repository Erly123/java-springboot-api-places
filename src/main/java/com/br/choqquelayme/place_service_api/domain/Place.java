package com.br.choqquelayme.place_service_api.domain;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

public record Place(
        @Id Long id,
        @NotBlank String name,
        String slug,
        @NotBlank String state,
        @CreatedDate LocalDateTime createdAt,
        @LastModifiedDate LocalDateTime updatedAt) {

    public Place withSlug(String slug) {
        return new Place(id, name, slug, state, createdAt, updatedAt);
    }
        
} 
