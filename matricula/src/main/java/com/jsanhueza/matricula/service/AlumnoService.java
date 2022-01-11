package com.jsanhueza.matricula.service;


import com.jsanhueza.matricula.model.Alumno;

import java.util.Optional;

public interface AlumnoService {
    Optional<Alumno> getAlumno(String codigo);
}
