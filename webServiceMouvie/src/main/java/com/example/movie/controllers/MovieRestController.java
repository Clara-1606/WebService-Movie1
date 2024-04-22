package com.example.movie.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.movie.models.Movie;
import com.example.movie.services.IMovieService;

@RestController
@RequestMapping("/api")
public class MovieRestController {
	
	private IMovieService service;

	@Autowired
	public MovieRestController(IMovieService service) {
		this.service = service;
	}

	@GetMapping("/movies")
	public ResponseEntity<Object> findAll() {
		List<Movie> movies = service.findAll();
		if (!movies.isEmpty()) {
			 return ResponseEntity.ok().body(movies); // 200 OK avec la liste des films
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucun films trouvé"); // 404 Not Found avec un message
	    }
	}

	// add mapping for GET /movies/{movieId}
	@GetMapping("/movies/{movieId}")
	public ResponseEntity<Object> getMovieById(@PathVariable int movieId) {
		Movie movie = service.findById(movieId);
		if (movie == null) {
			//throw new RuntimeException("Message id not found - " + movieId);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucun films trouvé"); // 404 Not Found
		}
		return ResponseEntity.ok().body(movie); // 200 OK avec la liste des films
	}

	// add mapping for POST /movies - add new movie
	@PostMapping(value = "/movies")
	public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
		// juste au cas où le client passe un id dans le JSON . . . on le set à 0
		// cela sauvegardera un nouvel élément, … au lieu de mettre à jour
		movie.setId(null);
		service.save(movie);
		return ResponseEntity.status(HttpStatus.CREATED).body(movie); // 201 Created
	}

	// mapping du PUT /movies - update existing movie
	@PutMapping("/movies")
	public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie) {
		service.save(movie);
		return ResponseEntity.ok().body(movie); // 200 OK
	}

	// mapping du DELETE /movies/{movieId} - delete movie
	@DeleteMapping("/movies/{movieId}")
	public ResponseEntity<Object> deleteMovie(@PathVariable int movieId) {
		Movie tempMovie = service.findById(movieId);
		// throw exception if null
		if (tempMovie == null)
			//throw new RuntimeException("his movie id not found - " + movieId);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucun film trouvé"); // 404 Not Found // 404 Not Found sans contenu
		service.deleteById(movieId);
		 return ResponseEntity.ok().body("Le film " + movieId + " est supprimé"); // 200 OK avec un message
	}

}
