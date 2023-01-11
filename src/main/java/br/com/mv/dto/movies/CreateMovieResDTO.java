package br.com.mv.dto.movies;

import br.com.mv.domain.Category;
import br.com.mv.dto.AbstractEntityDTO;
import br.com.mv.enums.NameCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateMovieResDTO extends AbstractEntityDTO {
    private Long id;

    private String title;

    private String year;

    private String duration;
}
