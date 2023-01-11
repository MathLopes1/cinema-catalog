package br.com.mv.dto.movies;

import java.util.List;

import br.com.mv.domain.Category;
import br.com.mv.dto.AbstractEntityDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MovieDTO extends AbstractEntityDTO {
    private Long id;

    @NotBlank(message = "Título do filme não pode ser vazio.")
    private String title;

    @NotBlank(message = "Ano do filme não pode ser vazio.")
    @Pattern(regexp = "^\\d{4}$", message = "Ano do filme deve ter 4 dígitos.")
    private String year;

    @NotBlank(message = "Duração do filme não pode ser vazia.")
    private String duration;

    List<Category> categories;
}
