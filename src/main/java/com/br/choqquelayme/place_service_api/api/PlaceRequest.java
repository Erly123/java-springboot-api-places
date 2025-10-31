package com.br.choqquelayme.place_service_api.api;


import jakarta.validation.constraints.NotBlank;

public record PlaceRequest(
        @NotBlank String name, @NotBlank String state) {
} 