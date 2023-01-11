package br.com.mv.service.inteface;

import br.com.mv.domain.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMovieService {
    public Movie create (Movie movie);
    public Movie updateById (Long id, Movie movie);
    public Movie getById (Long id);
    public Page<Movie> getAll (Pageable pagination);
    public void deleteById(Long id);
}
