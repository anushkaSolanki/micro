package com.example.ratingdataservice.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ratingdataservice.model.RatingsInfo;

@RestController
@RequestMapping("/rate")
public class RatingsResource {
    @GetMapping("/{movieId}")
    public RatingsInfo getRatingInfo(@PathVariable String movieId)
    {
        return new RatingsInfo(movieId,4);
    }

    @GetMapping("/users/{userId}")
    public  List<RatingsInfo> getRatingsInfo(@PathVariable String userId)
    {
        List<RatingsInfo> rate = Arrays.asList(
            new RatingsInfo("101",4),
            new RatingsInfo("102",5)
        );
        return rate;
    }
}
