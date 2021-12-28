package com.jsanhueza.alumno.repository;

import com.jsanhueza.alumno.model.Alumno;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlumnoRepository extends MongoRepository<Alumno, String> {
}
