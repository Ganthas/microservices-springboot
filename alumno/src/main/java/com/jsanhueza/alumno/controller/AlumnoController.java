package com.jsanhueza.alumno.controller;

import com.jsanhueza.alumno.model.Alumno;
import com.jsanhueza.alumno.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class AlumnoController {

    @Autowired
    AlumnoRepository alumnoRepository;

    @GetMapping(value = "/healthCatalogo", produces = "application/json; charset=utf-8")
    public String getHealthCheck()
    {
        return "{ \"todoOk\" : true }";
    }

    @GetMapping("/alumnos")
    public List<Alumno> getAlumnos()
    {
        List<Alumno> alumnosList = alumnoRepository.findAll();
        return alumnosList;
    }
}
