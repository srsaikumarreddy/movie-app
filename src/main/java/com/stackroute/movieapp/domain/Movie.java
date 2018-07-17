package com.stackroute.movieapp.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.stackroute.movieapp.services.MovieServiceImpl;

@Document

public class Movie {

    
	@Id

	int id;
	String title;
	String year;
	String poster;
	String imdbId;
	public Movie( String title, String year, String poster, String imdbId) {
		
		this.title = title;
		this.year = year;
		this.poster = poster;
		this.imdbId = imdbId;
	}
	
	public Movie() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id=id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	
	
	
}
