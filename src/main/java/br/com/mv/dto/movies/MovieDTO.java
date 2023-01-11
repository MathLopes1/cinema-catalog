package br.com.mv.dto.movies;

import java.util.List;

import br.com.mv.domain.Category;
import br.com.mv.dto.AbstractEntityDTO;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO extends AbstractEntityDTO {
    private Long id;

    private String title;

    private int year;

    private String duration;

    List<Category> categories;
}
