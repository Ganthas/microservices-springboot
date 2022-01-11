package com.jsanhueza.composer.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
public class Matricula {
    private Integer id;
    private String idAlumno;
    private Integer idCurso;
    private Date fechaMatricula;
}
