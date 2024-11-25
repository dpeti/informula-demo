package com.example.informula.demo.service.client.omdbapi.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OmdbSearchResponse {

    @JsonProperty("Search")
    private List<OmdbSearchMovie> search = new LinkedList<>();
}
