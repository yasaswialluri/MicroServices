package com.capg.moviecatelog.controller;

import org.springframework.cloud.netflix.ribbon.RibbonClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.capg.moviecatelog.model.MovieInfo;


@RibbonClient(value="movie-info-service")
//@FeignClient(value="movie-info-service")
public interface MovieInfoProxy {
	@GetMapping("movieinfo/{id}")
	public ResponseEntity<MovieInfo> getMovieInfo(@PathVariable("id") int id);
	@PostMapping("/movieinfo")
	public ResponseEntity<MovieInfo> addMovie(@RequestBody MovieInfo movie);
	@PutMapping("/movieinfo/{id}")
	 public void updateMovieInfoById(@PathVariable("id") int id, @RequestBody MovieInfo movie)  ;
	@DeleteMapping("/movieinfo/{id}")
	 public void deleteMovieInfoById(@PathVariable("id") int id)  ;
}
