package com.example.informula.demo.service;

import com.example.informula.demo.data.search.MovieSearchResults;
import com.example.informula.demo.service.client.omdbapi.OmdbApiClient;
import com.example.informula.demo.service.mapper.OmdbSearchResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieSearchService implements IMovieSearchService {

    private final OmdbApiClient omdbApiClient;

    /**
     * Search movie databases and return results
     *
     * @param movieTitle condition
     * @param apiName condition
     * @return Results by conditions
     */
    @Override
    public MovieSearchResults search(String movieTitle, String apiName) {
        if (apiName.equals("omdb")) {
            omdbApiClient.searchMovies(movieTitle)
        } else if (apiName.equals("tmdb")) {
            throw new UnsupportedOperationException();
        }
        return new MovieSearchResults();
    }
}
