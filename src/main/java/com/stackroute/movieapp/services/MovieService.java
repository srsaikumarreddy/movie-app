package com.stackroute.movieapp.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stackroute.movieapp.domain.Movie;
import com.stackroute.movieapp.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieapp.exceptions.MovieNotFoundException;


public interface MovieService {

	public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException;	
	
	
	 public Iterable<Movie> getallmovies();
	 
	 public Optional<Movie> getMovieById(int id) throws MovieNotFoundException;
	 
	 public String deleteById (int id) throws MovieNotFoundException;
	
	 public Movie Updatemovie(Movie movie,int id) throws MovieNotFoundException;
	 
	// public Iterable<Movie> getMovieByTitle(String title);
	
}
