package com.example.informula.demo.data.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

/**
 * Movie result
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieSearchResult {

    /**
     * Movie title
     */
    @JsonProperty("Title")
    private String title;

    /**
     * Year of publication
     */
    @JsonProperty("Year")
    private String year;

    /**
     * Movie directors
     */
    @JsonProperty("Director")
    private List<String> directors = new LinkedList<>();
}
