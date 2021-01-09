package com.capg.movieinfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="movieinfo_tbl")
public class MovieInfo {

	@Id
	@Column(name="mid")
	@GeneratedValue(generator="mygen",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="mygen",sequenceName="movie_seq",allocationSize=1)
	private int movieId;
	@Column(name="mtitle",length=15)
	private String movieTitle;
	@Column(name="language",length=15)
	private String language;
	@Column(name="genere",length=15)
	private String genere;
	@Column(name="rating")
	private int rating;

	public MovieInfo() {
		// TODO Auto-generated constructor stub
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public MovieInfo(int movieId, String movieTitle, String language, String genere, int rating) {
		super();
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.language = language;
		this.genere = genere;
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "MovieInfo [movieId=" + movieId + ", movieTitle=" + movieTitle + ", language=" + language + ", genere="
				+ genere + ", rating=" + rating + "]";
	}

			

	
	
	
	
}
