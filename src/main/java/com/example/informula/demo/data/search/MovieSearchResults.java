package com.example.informula.demo.data.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

/**
 * Movei results
 */
@Getter
@Setter
@NoArgsConstructor
public class MovieSearchResults {

    /**
     * List of movies by conditions
     */
    @JsonProperty("movies")
    List<MovieSearchResult> movies = new LinkedList<>();
}
