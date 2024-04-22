package com.example.movie.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.movie.dao.MovieRepository;
import com.example.movie.models.Movie;

@Service
public class MovieServiceImpl implements IMovieService{
	
	@Autowired
	private MovieRepository dao;

	@Override
	@Transactional
	public List<Movie> findAll() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public Movie findById(int id) {
		Optional<Movie> o = dao.findById(id);
		if (o.isPresent())
			return o.get();
		else
			throw new RuntimeException("Le film avec l'id n°" + id + ", n'existe pas en bdd");
	}

	@Override
	@Transactional
	public void save(Movie movie) {
		dao.save(movie);

	}

	@Override
	@Transactional
	public void deleteById(int id) {
		dao.deleteById(id);
	}

}
