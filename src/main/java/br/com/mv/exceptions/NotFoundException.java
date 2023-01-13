package br.com.mv.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundException extends AbstractException {
    public NotFoundException(String description) {
        super("Not Found", description);
    }
}

