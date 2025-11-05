package com.br.choqquelayme.place_service_api.web;

import com.br.choqquelayme.place_service_api.domain.PlaceMapper;
import org.springframework.web.bind.annotation.*;

import com.br.choqquelayme.place_service_api.api.PlaceRequest;
import com.br.choqquelayme.place_service_api.api.PlaceResponse;
import com.br.choqquelayme.place_service_api.domain.PlaceService;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/places")
public class PlaceController {

    private PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @PostMapping
    public ResponseEntity<Mono<PlaceResponse>> create(@Valid @RequestBody PlaceRequest request  ) {
        var placeResponse = placeService.create(request).map(PlaceMapper::toResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(placeResponse);
    }
    @PatchMapping("{id}")
    public Mono<PlaceResponse> edit(@PathVariable("id") Long id,@RequestBody PlaceRequest request  ) {
        return placeService.edit(id, request).map(PlaceMapper::toResponse);
    }
    

}
