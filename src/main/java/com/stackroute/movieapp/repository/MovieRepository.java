package com.stackroute.movieapp.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.movieapp.domain.Movie;

@Repository
public interface MovieRepository extends CrudRepository <Movie,Integer>{

	
	
	
	/*@Query(value="SELECT m from Movie m where m.title=?1")
	Iterable<Movie> findbytitle(String title);
*/	
}
