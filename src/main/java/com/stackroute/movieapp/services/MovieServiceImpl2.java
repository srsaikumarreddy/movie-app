package com.stackroute.movieapp.services;

import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.stackroute.movieapp.domain.Movie;
import com.stackroute.movieapp.repository.MovieRepository;
@Service

public class MovieServiceImpl2 implements MovieService{


	

	MovieRepository movierepository;
	
	public MovieServiceImpl2(MovieRepository movierepository) {
		super();
		this.movierepository = movierepository;
	}
	
	@Override
	public Movie saveMovie(Movie movie) {
		// TODO Auto-generated method stub
		return movierepository.save(movie);
	}

	@Override
	public Iterable<Movie> getallmovies() {
		// TODO Auto-generated method stub
		return movierepository.findAll();
	}

	@Override
	public Optional<Movie> getMovieById(int id) {
		// TODO Auto-generated method stub
		return movierepository.findById(id);
	}

	@Override
	public String deleteById(int id) {
		// TODO Auto-generated method stub
		 movierepository.deleteById(id);
    	 return "Deleted through s2";
	}

	@Override
	public Movie Updatemovie(Movie movie, int id) {
		// TODO Auto-generated method stub
		 movie.setId(id);
    	 return movierepository.save(movie);
	}

	/*@Override
	public Iterable<Movie> getMovieByTitle(String title) {
		// TODO Auto-generated method stub
		return movierepository.findbytitle(title);
	}
*/
}
