package com.jsanhueza.alumno.service;

import com.jsanhueza.alumno.model.Alumno;

import java.util.List;
import java.util.Optional;

public interface AlumnoService {
    Alumno save(Alumno alumno);
    String delete(String id);
    List<Alumno> findAll();
    Alumno findById(String codigo);
}
