package br.com.mv.controller;

import br.com.mv.domain.Movie;
import br.com.mv.dto.MovieDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.mv.service.MovieService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private MovieService movieService;

	@Autowired
	private ModelMapper modelMapper;

	private MovieDTO toMovieDTO (Movie movie) {
		return this.modelMapper.map(movie, MovieDTO.class);
	}

	@PostMapping
	public ResponseEntity<MovieDTO> create(@RequestBody MovieDTO movieDTO) {
		Movie newMovie = this.modelMapper.map(movieDTO, Movie.class);
		newMovie = this.movieService.create(newMovie);

		return new ResponseEntity<MovieDTO>(toMovieDTO(newMovie), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<MovieDTO> updateById(@RequestBody MovieDTO movieDTO, @PathVariable(value = "id") Long id) {
		Movie updatedMovie = this.modelMapper.map(movieDTO, Movie.class);
		updatedMovie = this.movieService.updateById(id,updatedMovie);

		return new ResponseEntity<MovieDTO>(toMovieDTO(updatedMovie),HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<MovieDTO>> getAll() {
		List<Movie> list = this.movieService.getAll();
		List<MovieDTO> listDto = list.stream()
				.map(x -> toMovieDTO(x))
				.collect(Collectors.toList());

		return ResponseEntity.ok().body(listDto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<MovieDTO> getById(@PathVariable Long id) {
		Movie movie = this.movieService.getById(id);

		return new ResponseEntity<MovieDTO>(toMovieDTO(movie), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		this.movieService.deleteById(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
