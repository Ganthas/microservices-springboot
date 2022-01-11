package com.jsanhueza.composer.service;

import com.jsanhueza.composer.models.Alumno;
import com.jsanhueza.composer.models.Curso;

import java.util.Optional;

public interface CursoService {
    Optional<Curso> getCurso(Integer codigo);
}
