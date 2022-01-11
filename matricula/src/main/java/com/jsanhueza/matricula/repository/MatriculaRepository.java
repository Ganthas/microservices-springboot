package com.jsanhueza.matricula.repository;

import com.jsanhueza.matricula.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula,Integer> {
    @Query(value = "SELECT * FROM matricula C WHERE C.id_alumno = ?1", nativeQuery = true)
    public List<Matricula> obtenerMatriculasAlumno(String codUser);
}