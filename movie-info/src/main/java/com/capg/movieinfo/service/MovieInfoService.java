package com.capg.movieinfo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.movieinfo.dao.MovieInfoDao;
import com.capg.movieinfo.exception.MovieException;
import com.capg.movieinfo.model.MovieInfo;

@Service
public class MovieInfoService {
	
	//List<MovieInfo> movies=Arrays.asList(new MovieInfo(1001,"Gita Govindam","Love Stroy"),
			//new MovieInfo(1002,"Bahubali","Drama")
			//);
	
	@Autowired
	MovieInfoDao  movieInfoDao;

	public List<MovieInfo> getMovie() throws MovieException {
		
		return movieInfoDao.findAll();
	}
	
	public MovieInfo getMovieById(int id) throws MovieException {
		//return movies.stream().filter(m->m.getMovieId()==id).findFirst().orElse(null);
		if(!movieInfoDao.existsById(id))
		{
			
			 throw new MovieException(" ID NOT FOUND");
		}
		return movieInfoDao.findById(id).get();
	}
	public MovieInfo addMovie(MovieInfo movieInfo)
	{
		return movieInfoDao.saveAndFlush(movieInfo);
	}
	
	public void updateMovie(int movieId,MovieInfo movie) throws MovieException
	{
		
		if(!movieInfoDao.existsById(movieId))
		{
			
			 throw new MovieException(" ID NOT FOUND");
		}
	 movieInfoDao.saveAndFlush(movie);
	}
	
	public void deleteMovie(int movieId) throws MovieException
	{
		if(!movieInfoDao.existsById(movieId))
		{
			
			 throw new MovieException(" ID NOT FOUND");
		}
		movieInfoDao.deleteById(movieId);
	}
}
