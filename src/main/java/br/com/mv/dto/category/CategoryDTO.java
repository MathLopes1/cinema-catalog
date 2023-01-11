package br.com.mv.dto.category;

import br.com.mv.domain.AbstractEntity;
import br.com.mv.enums.NameCategory;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryDTO extends AbstractEntity implements Serializable  {
    private static final long serialVersionUID = 1L;

    private Long id;

    private NameCategory name;

    @NotBlank(message = "Descrição da categoria não pode ser vazia.")
    private String description ;
}
