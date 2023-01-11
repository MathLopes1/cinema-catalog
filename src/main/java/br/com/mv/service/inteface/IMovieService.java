package br.com.mv.service.inteface;

import br.com.mv.domain.Movie;

import java.util.List;

public interface IMovieService {
    public Movie create (Movie movie);
    public Movie updateById (Long id, Movie movie);
    public Movie getById (Long id);
    public List<Movie> getAll ();
    public void deleteById(Long id);
}
