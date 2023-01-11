package br.com.mv.dto;

import br.com.mv.domain.AbstractEntity;
import br.com.mv.enums.NameCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO extends AbstractEntity implements Serializable  {
    private static final long serialVersionUID = 1L;

    private Long id;

    private NameCategory name;

    private String description ;
}
