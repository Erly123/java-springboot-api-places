package com.br.choqquelayme.place_service_api.util;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import com.br.choqquelayme.place_service_api.domain.Place;

public class QueryBuilder {
  private QueryBuilder() {
  }

  public static Example<Place> makeQuery(Place place) {
    ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase().withIgnoreNullValues();
    return Example.of(place, exampleMatcher);
  }
}
