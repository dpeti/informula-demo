package com.example.informula.demo.service;


import com.example.informula.demo.data.search.MovieSearchResults;

public interface IMovieSearchService {

    MovieSearchResults search(String movieTitle, String apiName);
}
