package com.br.choqquelayme.place_service_api.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.choqquelayme.place_service_api.api.PlaceRequest;
import com.br.choqquelayme.place_service_api.api.PlaceResponse;
import com.br.choqquelayme.place_service_api.domain.Place;
import com.br.choqquelayme.place_service_api.domain.PlaceService;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/places")
public class PlaceController {

    private PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping
    public ResponseEntity<Mono<PlaceResponse>> create(@Valid @RequestBody PlaceRequest request  ) {
        var placeResponse = placeService.create(request).map(PlaceMapper::fromtPlaceResponse); 
        return ResponseEntity.status(HttpStatus.CREATED).body(placeResponse);
    }
    

}
