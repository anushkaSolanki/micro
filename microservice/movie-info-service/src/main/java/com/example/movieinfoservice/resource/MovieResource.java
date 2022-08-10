package com.example.movieinfoservice.resource;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movieinfoservice.model.Movies;

@RestController
@RequestMapping("/movie")
public class MovieResource {
    
    @GetMapping("/{movieId}")
    public Movies getMovieInfo(@PathVariable("movieId") String movieId)
    {
        return new Movies(movieId,"movieName");
    }
}
