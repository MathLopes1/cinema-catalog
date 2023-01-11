package br.com.mv.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AbstractEntityDTO {
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDateTime createdAt;

    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDateTime updatedAt;
}
