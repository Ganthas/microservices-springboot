package com.jsanhueza.composer.service;

import com.jsanhueza.composer.models.Alumno;

import java.util.Optional;

public interface AlumnoService {
    Optional<Alumno> getAlumno(String codigo);
}
