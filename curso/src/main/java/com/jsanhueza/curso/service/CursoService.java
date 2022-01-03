package com.jsanhueza.curso.service;

import com.jsanhueza.curso.model.Curso;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    Curso save(Curso curso);
    String delete(Integer id);
    List<Curso> findAll();
    Curso findById(Integer codigo);
}
