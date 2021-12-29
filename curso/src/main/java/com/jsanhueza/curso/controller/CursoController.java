package com.jsanhueza.curso.controller;

import com.jsanhueza.curso.model.Curso;
import com.jsanhueza.curso.repository.CursoRepository;
import com.jsanhueza.curso.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @GetMapping("/cursos")
    public List<Curso> getAlumnos()
    {
        List<Curso> cursosList = cursoService.findAll();
        return cursosList;
    }

    @PostMapping("/curso")
    public Curso save(@RequestBody Curso newCurso)
    {
        Curso curso = new Curso();
        curso.setNombre(newCurso.getNombre());
        curso.setDuracion(newCurso.getDuracion());
        curso.setPrecio(newCurso.getPrecio());
        cursoService.save(curso);
        return curso;
    }
}