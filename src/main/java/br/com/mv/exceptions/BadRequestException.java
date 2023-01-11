package br.com.mv.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BadRequestException extends AbstractException {
    public BadRequestException(String descricao) {
        super("Bad Request", descricao);
    }
}

