package br.com.mv.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundException extends AbstractException {
    public NotFoundException(String descricao) {
        super("Not Found", descricao);
    }
}

