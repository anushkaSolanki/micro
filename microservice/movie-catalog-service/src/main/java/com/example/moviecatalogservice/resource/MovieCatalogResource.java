package com.example.moviecatalogservice.resource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.moviecatalogservice.models.CatalogItem;
import com.example.moviecatalogservice.models.Movies;
import com.example.moviecatalogservice.models.RatingsInfo;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;
    

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatlog(@PathVariable("userId") String userId)
    {
        //RestTemplate restTemplate = new RestTemplate();
        //restTemplate.getForObject("http://localhost:8082/movie/101", Movies.class);

        List<RatingsInfo> rate = Arrays.asList(
            new RatingsInfo("101",4),
            new RatingsInfo("102",5)
        );

        return rate.stream().map(rating -> { 
            Movies movie= restTemplate.getForObject("http://localhost:8082/movie/"+rating.getMovieId(), Movies.class);
            return new CatalogItem(movie.getMovieName(),"movieDesc of "+movie.getMovieId(),rating.getRating());
        }).collect(Collectors.toList());

        //return Collections.singletonList(new CatalogItem("movieName", "movieDesc", 4));
    }
    
}
