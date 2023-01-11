package br.com.mv.service;

import br.com.mv.domain.Movie;
import br.com.mv.service.inteface.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
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
		Optional<Movie> patient = this.movieRepository.findById(id);
		return patient.orElseThrow(() -> new Error("object not found"));
	}

	@Override
	public List<Movie> getAll() {
		return this.movieRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		this.getById(id);
		this.movieRepository.deleteById(id);
	}

	private void updateData(Movie updateMovie, Movie movie) {
		updateMovie.setDuration(movie.getDuration());
		updateMovie.setTitle(movie.getTitle());
		updateMovie.setYear(movie.getYear());
		updateMovie.setUpdatedAt(LocalDateTime.now());
	}
}
