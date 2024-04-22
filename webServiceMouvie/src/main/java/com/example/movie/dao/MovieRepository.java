package com.example.movie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.movie.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
	// find =select
	public List<Movie> findByName(String name);


}
