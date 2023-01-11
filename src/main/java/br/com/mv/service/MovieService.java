package br.com.mv.service;

import br.com.mv.domain.Movie;
import br.com.mv.exceptions.BadRequestException;
import br.com.mv.exceptions.NotFoundException;
import br.com.mv.service.inteface.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.mv.repository.MovieRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService implements IMovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Movie create(Movie movie) {
		this.validationForMovieCreation(movie);

		movie.setCreatedAt(LocalDateTime.now());
		movie.setUpdatedAt(LocalDateTime.now());

		Movie newMovie = movieRepository.save(movie);
		return newMovie;
	}

	@Override
	public Movie updateById (Long id, Movie movie) {
		Movie updatedMovie = this.getById(id);

		this.updateData(updatedMovie, movie);

		return this.movieRepository.save(updatedMovie);
	}

	@Override
	public Movie getById(Long id) {
		Optional<Movie> movie = this.movieRepository.findById(id);

		return movie.orElseThrow(() -> new NotFoundException("Filme não existe!"));
	}

	@Override
	public Page<Movie> getAll(Pageable pagination) {
		return this.movieRepository.findAll(pagination);
	}

	@Override
	public void deleteById(Long id) {
		this.getById(id);

		this.movieRepository.deleteById(id);
	}

	private void updateData(Movie updateMovie, Movie movie) {
		if(movie.getDuration() != null) {
			updateMovie.setDuration(movie.getDuration());
		}

		if(movie.getTitle() != null) {
			updateMovie.setTitle(movie.getTitle());
		}

		if(movie.getYear() > 0) {
			updateMovie.setYear(movie.getYear());
		}

		updateMovie.setUpdatedAt(LocalDateTime.now());
	}

	private void validationForMovieCreation(Movie movie) {
		Optional<Movie> movieForValidation = this.movieRepository.findByTitle(movie.getTitle());

		if(movieForValidation.isPresent()) {
			throw new BadRequestException("Filme já cadastrado!");
		}
	}
}
