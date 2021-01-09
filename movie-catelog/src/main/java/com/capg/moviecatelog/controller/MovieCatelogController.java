package com.capg.moviecatelog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capg.moviecatelog.exception.MovieException;

import com.capg.moviecatelog.model.MovieDetail;
import com.capg.moviecatelog.model.MovieInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class MovieCatelogController {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/movie")
	public ResponseEntity<List<MovieInfo>>  getMovie()
	{
		ResponseEntity<MovieDetail> md = restTemplate.getForEntity("http://movie-info-service/movieinfo",MovieDetail.class);
		List<MovieInfo> list = md.getBody().getList();
		
		ResponseEntity<List<MovieInfo>>  re= new ResponseEntity<>(list,HttpStatus.OK);
		return re;
	}
	
	@PutMapping("/movie/{id}")
	public void updateMovieInfoById(@PathVariable int id ,@RequestBody MovieInfo movie) 
	{
		 restTemplate.put("http://movie-info-service/movieinfo/"+id, movie, id);
		
		
	}
	
	@DeleteMapping("/movie/{id}")
	public void deleteMovieInfoById(@PathVariable int id ) 
	{
		 restTemplate.delete("http://movie-info-service/movieinfo/"+id, id);;
		
		
	}
	@PostMapping("/movie")
	public ResponseEntity<MovieInfo>  addMovie(@RequestBody MovieInfo movie)
	{
		ResponseEntity<MovieInfo> md = restTemplate.postForEntity("http://movie-info-service/movieinfo", movie, MovieInfo.class);
		MovieInfo list = md.getBody();
		
		ResponseEntity<MovieInfo>  re= new ResponseEntity<>(list,HttpStatus.OK);
		return re;
	}
	
	
	@GetMapping("/movie/{id}")
	//@HystrixCommand(fallbackMethod="fallBackMovieCatelogItem")
	public ResponseEntity<MovieInfo> getMovieCatelogItem(@PathVariable int id) throws MovieException {	
   ResponseEntity<MovieInfo> infoEntity=restTemplate.getForEntity("http://movie-info-service/movieinfo/"+id, MovieInfo.class);
   if(infoEntity.getStatusCode()==HttpStatus.NOT_FOUND)
	{
		
		throw new MovieException("MOVIE "+ id +" NOT FOUND ");
	}
	MovieInfo info=infoEntity.getBody();
	ResponseEntity<MovieInfo>  re=new ResponseEntity<>(info,HttpStatus.OK);	
		return re;
	}	
}
