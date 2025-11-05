package com.br.choqquelayme.place_service_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

import com.br.choqquelayme.place_service_api.domain.PlaceRepository;
import com.br.choqquelayme.place_service_api.domain.PlaceService;

@Configuration
@EnableR2dbcAuditing
public class PlaceServiceConfig {

    @Bean
    PlaceService placeService(PlaceRepository placeRepository) {
        return new PlaceService(placeRepository);

    }

}
