package com.jsanhueza.composer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Curso {
    private Integer id;
    private String nombre;
    private String duracion;
    private String precio;
}
