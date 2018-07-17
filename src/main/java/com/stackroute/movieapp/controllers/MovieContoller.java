package com.stackroute.movieapp.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.movieapp.domain.Movie;
import com.stackroute.movieapp.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieapp.exceptions.MovieNotFoundException;
import com.stackroute.movieapp.services.MovieService;
import static org.springframework.data.mongodb.core.query.Query.*;
import static org.springframework.data.mongodb.core.query.Criteria.*;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.*;


@RestController
@RequestMapping("api/v1")
public class MovieContoller {
	
	
MovieService movieService;

@Autowired	
Environment env;

//@Autowired
//
//public MovieContoller(MovieService movieService) {
//	
//	this.movieService = movieService;
//}
private final Logger logger = LoggerFactory.getLogger(this.getClass());

@PostMapping("/movie")
public ResponseEntity<?>saveMovie(@RequestBody Movie movie) throws MovieAlreadyExistsException
{ 
	try {
		logger.info("anannaan");
		logger.debug("This is a debug message nkdnckcjsnkcksb");
		logger.warn("Sdfdafsfs");
		System.out.println(env.getProperty("com.stackroute.username"));
		movieService.saveMovie(movie);
 	return new ResponseEntity<Movie>(movie, HttpStatus.CREATED);
	}
	 catch(MovieAlreadyExistsException e){
         return new ResponseEntity<String>("User Already Exists",HttpStatus.CONFLICT);
     }
}

@GetMapping("/movies")
public ResponseEntity<?>getAllMovies()
{    logger.debug("This is a debug message");
 	return new ResponseEntity<Iterable<Movie>>(movieService.getallmovies(), HttpStatus.OK);

	
}
@RequestMapping(value = "/home" , method = RequestMethod.GET)
public String displayRestaurant() {
    return "Hello";
}


   
/*@GetMapping("/moviename/{title}")
public ResponseEntity<?>getMovieByTitle(@PathVariable ("title")String title)
{
	return new ResponseEntity<Iterable<Movie>>(movieService.getMovieByTitle(title),HttpStatus.OK);
}*/


@GetMapping("/movie/{id}")
public ResponseEntity<?>getMovieById(@PathVariable ("id")int id) throws MovieNotFoundException
{
	try{ logger.debug("This is a debug message");
	Optional<Movie>movie1=movieService.getMovieById(id);
		return new ResponseEntity<Optional<Movie>>(movie1,HttpStatus.OK);
	}
	catch(MovieNotFoundException e) {
        return new ResponseEntity<String> ("Movie of this Id not present",HttpStatus.CONFLICT);
     }
}

@DeleteMapping("/movie/{id}")
public ResponseEntity<?>deleteMovieById(@PathVariable ("id")int id) throws MovieNotFoundException
{
	try {
		
		movieService.deleteById(id);
		return new ResponseEntity<String> ("Deleted",HttpStatus.CONFLICT);
	}
	catch(MovieNotFoundException e){return new ResponseEntity<String>("id not there",HttpStatus.OK); 
            }
}
@PutMapping("/movie/{id}")
public ResponseEntity<?>updatemovie(@RequestBody Movie movie,@PathVariable ("id") int id) throws MovieNotFoundException
{
try {
		
		Movie movie1=movieService.Updatemovie(movie, id);
		return new ResponseEntity<Movie> (movie1,HttpStatus.CONFLICT);
	}
	catch(MovieNotFoundException e){return new ResponseEntity<String>("id not there",HttpStatus.OK); 
            }
}
}



