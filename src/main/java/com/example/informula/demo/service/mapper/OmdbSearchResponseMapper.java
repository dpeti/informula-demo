package com.example.informula.demo.service.mapper;

import com.example.informula.demo.data.search.MovieSearchResult;
import com.example.informula.demo.data.search.MovieSearchResults;
import com.example.informula.demo.service.client.omdbapi.data.OmdbMovie;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class OmdbSearchResponseMapper {

    public MovieSearchResults toResults(List<OmdbMovie> omdbMovies) {
        MovieSearchResults results = new MovieSearchResults();
        results.getMovies().addAll(omdbMovies.stream().map(this::toResult).toList());
        return results;
    }

    public MovieSearchResult toResult(OmdbMovie omdb) {
        MovieSearchResult result = new MovieSearchResult();
        result.setTitle(omdb.getTitle());
        result.setYear(omdb.getYear());
        result.getDirectors().addAll(getDirectors(omdb.getDirector()));
        return result;
    }

    private List<String> getDirectors(String directors) {
        return Arrays.asList(directors.split(","));
    }
}
