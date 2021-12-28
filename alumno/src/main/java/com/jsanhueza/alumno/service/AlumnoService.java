package com.jsanhueza.alumno.service;

import com.jsanhueza.alumno.model.Alumno;

public interface AlumnoService {
    Alumno save(Alumno producto);
    String delete(String id);
}
