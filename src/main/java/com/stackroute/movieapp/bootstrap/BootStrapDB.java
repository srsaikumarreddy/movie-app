package com.stackroute.movieapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import com.stackroute.movieapp.domain.Movie;
import com.stackroute.movieapp.repository.MovieRepository;

@Configuration
public class BootStrapDB  implements ApplicationListener<ContextRefreshedEvent>{

	private MovieRepository movieRep;
	
	@Autowired
	 public BootStrapDB(MovieRepository movieRep)
	 {
		  this.movieRep=movieRep;
	 }

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
	//	Movie movie=new Movie("sai","432","gdsgdfg","gfdsfgdg");
		//movieRep.save(movie);
	}
	 
	
	
}
