package com.jsanhueza.matricula.service;


import com.jsanhueza.matricula.model.Curso;

import java.util.Optional;

public interface CursoService {
    Optional<Curso> getCurso(Integer codigo);
}
