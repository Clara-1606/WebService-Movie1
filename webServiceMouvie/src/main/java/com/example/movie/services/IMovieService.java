package com.example.movie.services;

import java.util.List;

import com.example.movie.models.Movie;

public interface IMovieService {
	
	public List<Movie> findAll();

	// Lire un seul message
	public Movie findById(int id);

	// Ecrire & modifier
	public void save(Movie movie);

	// supprimer
	public void deleteById(int id);
}
