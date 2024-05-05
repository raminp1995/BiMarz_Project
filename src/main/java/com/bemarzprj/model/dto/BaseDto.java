package com.bemarzprj.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BaseDto
{
    @JsonIgnore
    private Long id;

    private LocalDate created_at;

    private LocalDate updated_at;

    private Boolean deleted = false;
}
