package br.com.mv.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AbstractEntity {
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDateTime createdAt;

    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDateTime updatedAt;
}
