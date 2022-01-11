package com.jsanhueza.composer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class MatriculaAlumno {
    private Integer idMatricula;
    private Alumno alumno;
    private Curso curso;
    private Date fecha;
}
