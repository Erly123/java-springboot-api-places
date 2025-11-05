package com.br.choqquelayme.place_service_api.domain;

import com.br.choqquelayme.place_service_api.api.PlaceRequest;
import com.br.choqquelayme.place_service_api.api.PlaceResponse;
import org.springframework.util.StringUtils;

public class PlaceMapper {

    public static Place updatePlaceFromDTO(PlaceRequest placeRequest, Place place) {
        final String name = StringUtils.hasText(placeRequest.name()) ? placeRequest.name() : place.name();
        final String state = StringUtils.hasText(placeRequest.state()) ? placeRequest.state() : place.state();
        return new Place(place.id(), name, place.slug(), state, place.createdAt(), place.updatedAt());
    }
    public static PlaceResponse toResponse(Place place) {
        return new PlaceResponse(place.name(), place.slug(), place.state(), place.createdAt(), place.updatedAt());
    }
}
