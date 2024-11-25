package com.example.informula.demo.rest;

import com.example.informula.demo.data.search.MovieSearchResults;
import com.example.informula.demo.service.IMovieSearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class MovieSearchController {

    private final IMovieSearchService movieSearchService;

    /**
     *
     * @param movieTitle
     * @param apiName
     * @return
     */
    @GetMapping("/movies/{movieTitle}")
    public ResponseEntity<MovieSearchResults> search(@PathVariable String movieTitle,
                                                     @RequestParam(required = false) String apiName) {
        log.info("");
        return ResponseEntity.ok().body(movieSearchService.search(movieTitle, apiName));
    }
}
