package com.br.choqquelayme.place_service_api.domain;

import com.br.choqquelayme.place_service_api.api.PlaceRequest;
import com.github.slugify.Slugify;

import reactor.core.publisher.Mono;

public class PlaceService {
   private PlaceRepository placeRepository;
   private Slugify slg;

   public PlaceService(PlaceRepository placeRepository) {
    this.placeRepository = placeRepository;
    this.slg = Slugify.builder().build();
   }
   public Mono<Place> create(PlaceRequest placeRequest) {
      var place= new Place(
              null,
              placeRequest.name(),
              slg.slugify(placeRequest.name()),
              placeRequest.state(),
              null,
              null);
      return placeRepository.save(place);
   }
   public Mono<Place> edit(Long id, PlaceRequest placeRequest) {
      return placeRepository.findById(id)
              .map(place -> PlaceMapper.updatePlaceFromDTO(placeRequest, place))
              .map(place -> place.withSlug(slg.slugify(place.name())))
              .flatMap(placeRepository::save);
   }
    public Mono<Place> get(Long id) {
        return placeRepository.findById(id);
    }

}
