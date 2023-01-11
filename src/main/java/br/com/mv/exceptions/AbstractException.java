package br.com.mv.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class AbstractException extends RuntimeException{
    private String erro;
    private String descricao;
}
