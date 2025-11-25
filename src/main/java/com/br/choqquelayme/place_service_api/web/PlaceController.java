package com.br.choqquelayme.place_service_api.web;

import com.br.choqquelayme.place_service_api.domain.PlaceMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.br.choqquelayme.place_service_api.api.PlaceRequest;
import com.br.choqquelayme.place_service_api.api.PlaceResponse;
import com.br.choqquelayme.place_service_api.domain.PlaceService;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/places")
@Tag(name = "Places", description = "Gerenciador de lugares")
public class PlaceController {

    @Autowired
    private PlaceService placeService;


    @PostMapping
    @Operation(summary = "Cadastrar lugares",description = "Cadastra un novo lugar na base de memoria e dura somente o tempo de execuçao!")
    public ResponseEntity<Mono<PlaceResponse>> create(@Valid @RequestBody PlaceRequest request  ) {
        var placeResponse = placeService.create(request).map(PlaceMapper::toResponse);
        return ResponseEntity.status(HttpStatus.CREATED).body(placeResponse);
    }
    @PatchMapping("{id}")
    @Operation(summary = "Atualizar lugares",description = "Atualiza un novo lugar na base de memoria e dura somente o tempo de execuçao!")
    public Mono<PlaceResponse> edit(@PathVariable("id") Long id,@RequestBody PlaceRequest request  ) {
        return placeService.edit(id, request).map(PlaceMapper::toResponse);
    }
    @GetMapping("{id}")
    @Operation(summary = "Conseguir lugares",description = "Conseguir un novo lugar na base de memoria e dura somente o tempo de execuçao!")
    public Mono<ResponseEntity<PlaceResponse>> get(@PathVariable("id") Long id) {
        return placeService.get(id)
                .map(place -> ResponseEntity.ok(PlaceMapper.toResponse(place)))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    
    @GetMapping
    @Operation(summary = "Conseguir lugar ou lugares por nome",description = "Conseguir um lugar mediante seu nome na base de memoria e dura somente o tempo de execuçao!")
    public Flux<PlaceResponse> list(@RequestParam(required = false) String name) {
        return placeService.list(name).map(PlaceMapper::toResponse);
    }
    

}
