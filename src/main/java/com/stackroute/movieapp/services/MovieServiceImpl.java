package com.stackroute.movieapp.services;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.stackroute.movieapp.domain.Movie;
import com.stackroute.movieapp.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieapp.exceptions.MovieNotFoundException;
import com.stackroute.movieapp.repository.MovieRepository;
@Service
@Primary
public class MovieServiceImpl implements MovieService {

	MovieRepository movierepository;
	
    @Autowired
	public MovieServiceImpl(MovieRepository movierepository) {
		
		this.movierepository = movierepository;
	}
   
    @Autowired
      NextSequenceService nextsequenceservice;
 
   

    
    
    public Movie saveMovie(Movie movie) throws MovieAlreadyExistsException
    {  
        movie.setId( nextsequenceservice.getNextSequence("counters"));
    	
    	 Movie movie1=movierepository.save(movie);
    		if(movie==null)
    			throw new MovieAlreadyExistsException("Movie already exists");
    		else return movie1;
    }
    
    public Iterable<Movie> getallmovies()
    {
    	 return movierepository.findAll();
    }
    public Optional<Movie> getMovieById(int id) throws MovieNotFoundException
    { 
    	Optional<Movie> movie1=movierepository.findById(id);
    	if(!movie1.isPresent())
			throw new MovieNotFoundException("Movie doesnt exist");
		else return movie1;
    	
    }
    
    public String deleteById(int id) throws MovieNotFoundException
    {
    	 Optional<Movie> movie=getMovieById(id);
		 if(movie.isPresent()) {
			  movierepository.deleteById(id);return "deleted through s1";
		 }else {
			 throw new MovieNotFoundException("Movie not found");
		 }
    }
    public Movie Updatemovie(Movie movie,int id) throws MovieNotFoundException
    {
    	Optional<Movie> movie1=getMovieById(id);
    	if(movie1.isPresent())
    	{    	 movie.setId(id);
        return  movierepository.save(movie);}
    	else
			throw new MovieNotFoundException("Movie doesnt exist");
		
    }
   
    
	public MovieRepository getMovierepository() {
		return movierepository;
	}

	public void setMovierepository(MovieRepository movierepository) {
		this.movierepository = movierepository;
	}

/*	@Override
	public Iterable<Movie> getMovieByTitle(String title) {
		return movierepository.findbytitle(title);
		
	}*/
	
	
	
}
