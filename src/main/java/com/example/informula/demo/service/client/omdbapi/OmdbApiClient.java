package com.example.informula.demo.service.client.omdbapi;

import com.example.informula.demo.data.search.MovieSearchResults;
import com.example.informula.demo.service.client.omdbapi.data.OmdbMovie;
import com.example.informula.demo.service.client.omdbapi.data.OmdbSearchMovie;
import com.example.informula.demo.service.client.omdbapi.data.OmdbSearchResponse;
import com.example.informula.demo.service.mapper.OmdbSearchResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Component
@RequiredArgsConstructor
public class OmdbApiClient {

    private final OmdbSearchResponseMapper omdbSearchResponseMapper;

    @Value("${omdbapi.url}")
    private String omdbApiUrl;

    @Value("${omdbapi.key}")
    private String omdbApiKey;

    public MovieSearchResults searchMovies(String query) {
        OmdbSearchResponse omdbSearchResponses = getOmdbMovieSearchResults(query);
        if (!omdbSearchResponses.getSearch().isEmpty()) {
            List<OmdbMovie> movies = new LinkedList<>();
            for (OmdbSearchMovie search : omdbSearchResponses.getSearch()) {
                movies.add(getOmdbMovieDetails(search));
            }
            return omdbSearchResponseMapper.toResults(movies);
        }
        return new MovieSearchResults();
    }

    private OmdbSearchResponse getOmdbMovieSearchResults(String query) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(omdbApiUrl, OmdbSearchResponse.class, getOmdbMovieSearchParams(query));
    }

    private OmdbMovie getOmdbMovieDetails(OmdbSearchMovie movie) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(omdbApiUrl, OmdbMovie.class, getOmdbMovieDetailsParams(movie.getImdbId()));
    }

    private Map<String, String> getOmdbMovieSearchParams(String query) {
        Map<String, String> omdbSearchParams = new HashMap<>();
        omdbSearchParams.put("s", query);
        addApiKey(omdbSearchParams);
        return omdbSearchParams;
    }

    private Map<String, String> getOmdbMovieDetailsParams(String movieId) {
        Map<String, String> omdbMovieParams = new HashMap<>();
        omdbMovieParams.put("t", movieId);
        addApiKey(omdbMovieParams);
        return omdbMovieParams;
    }

    private void addApiKey(Map<String, String> params) {
        params.put("apiKey", omdbApiKey);
    }
}
