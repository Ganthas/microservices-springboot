package com.jsanhueza.alumno.service;

import com.jsanhueza.alumno.model.Alumno;

import java.util.List;

public interface AlumnoService {
    Alumno save(Alumno alumno);
    String delete(String id);
    List<Alumno> findAll();
}
