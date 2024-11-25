package com.example.informula.demo.service.client.omdbapi.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OmdbMovieRating {

    @JsonProperty("Source")
    private String source;

    @JsonProperty("Value")
    private String value;
}
