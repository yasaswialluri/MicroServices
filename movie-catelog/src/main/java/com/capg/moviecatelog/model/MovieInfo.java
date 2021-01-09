package com.capg.moviecatelog.model;




public class MovieInfo {

	private int movieId;
	private String movieTitle;
	private String language;
	private String genere;
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
