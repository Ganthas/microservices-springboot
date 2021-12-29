package com.jsanhueza.curso.repository;

import com.jsanhueza.curso.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso,Integer> {
}
