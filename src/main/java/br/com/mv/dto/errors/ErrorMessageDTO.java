package br.com.mv.dto.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorMessageDTO {
    private int status;
    private String erro;
    private String descricao;
}
