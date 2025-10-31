package com.br.choqquelayme.place_service_api.web;

import com.br.choqquelayme.place_service_api.api.PlaceResponse;
import com.br.choqquelayme.place_service_api.domain.Place;

public class PlaceMapper {
    public static PlaceResponse fromtPlaceResponse(Place place) {
        return new PlaceResponse(place.name(), place.slug(), place.state(), place.createdAt(), place.updatedAt());
    }
}
