package com.capg.movieinfo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.movieinfo.model.MovieInfo;

@Repository
public interface MovieInfoDao extends JpaRepository<MovieInfo,Integer>
{

}
