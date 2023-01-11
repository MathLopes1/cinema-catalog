package br.com.mv.controller;

import br.com.mv.domain.Movie;
import br.com.mv.dto.movies.CreateMovieResDTO;
import br.com.mv.dto.movies.MovieDTO;
import br.com.mv.service.inteface.IMovieService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private IMovieService movieService;

	@Autowired
	private ModelMapper modelMapper;

	private MovieDTO toMovieDTO (Movie movie) {
		return this.modelMapper.map(movie, MovieDTO.class);
	}


	@PostMapping
	public ResponseEntity<CreateMovieResDTO> create(@RequestBody @Valid MovieDTO movieDTO) {

		Movie newMovie = this.modelMapper.map(movieDTO, Movie.class);
		newMovie = this.movieService.create(newMovie);

		return new ResponseEntity<CreateMovieResDTO>(
				this.modelMapper.map(newMovie, CreateMovieResDTO.class),
				HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<MovieDTO> updateById(@RequestBody MovieDTO movieDTO, @PathVariable(value = "id") Long id) {
		Movie updatedMovie = this.modelMapper.map(movieDTO, Movie.class);
		updatedMovie = this.movieService.updateById(id,updatedMovie);

		return new ResponseEntity<MovieDTO>(toMovieDTO(updatedMovie),HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Page<MovieDTO>> getAll(@PageableDefault(sort = "title") Pageable pagination) {
		Page<Movie> list = this.movieService.getAll(pagination);

		Page<MovieDTO> listDto = list.map(x -> toMovieDTO(x));

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

		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
