package com.jsanhueza.alumno.controller;

import com.jsanhueza.alumno.model.Alumno;
import com.jsanhueza.alumno.repository.AlumnoRepository;
import com.jsanhueza.alumno.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class AlumnoController {

    @Autowired
    AlumnoService alumnoService;

    @GetMapping("/alumnos")
    public List<Alumno> getAlumnos()
    {
        List<Alumno> alumnosList = alumnoService.findAll();
        return alumnosList;
    }

    @GetMapping("/alumno/{codigo}")
    public Alumno getAlumno(@PathVariable String codigo)
    {
        Optional<Alumno> alumno = alumnoService.findById(codigo);
        Alumno alumnoTemp = alumno.get();
        return alumnoTemp;
    }

    @PostMapping("/alumno")
    public Alumno save(@RequestBody Alumno newAlumno)
    {
        Alumno alumno = new Alumno();
        alumno.setNombre(newAlumno.getNombre());
        alumno.setApellido(newAlumno.getApellido());
        alumno.setEstatura(newAlumno.getEstatura());
        alumnoService.save(alumno);
        return alumno;
    }
}
