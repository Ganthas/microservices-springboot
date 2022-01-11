package com.jsanhueza.matricula.controller;

import com.jsanhueza.matricula.model.Alumno;
import com.jsanhueza.matricula.model.Curso;
import com.jsanhueza.matricula.model.Matricula;
import com.jsanhueza.matricula.model.MatriculaAlumno;
import com.jsanhueza.matricula.repository.MatriculaRepository;
import com.jsanhueza.matricula.service.AlumnoService;
import com.jsanhueza.matricula.service.CursoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class MatriculaController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    MatriculaRepository matriculaRepository;

    @Autowired
    AlumnoService alumnoService;

    @Autowired
    CursoService cursoService;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3")})
    @GetMapping("/alumno/{codigo}")
    public Alumno getAlumno(@PathVariable String codigo)
    {
        Alumno alumno = restTemplate.getForObject("http://ALUMNO.SERVICIO/alumno/"+codigo, Alumno.class);
        return alumno;
    }

    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3")})
    @GetMapping("/alumno/alumnos")
    public List<Alumno> getAlumnos()
    {
        Alumno[] response = restTemplate.getForObject("http://ALUMNO.SERVICIO/alumnos/", Alumno[].class);
        List<Alumno> alumnoList = Arrays.asList(response);
        return alumnoList;
    }

    @GetMapping("/matricula/alumno/{codigo}")
    public List<MatriculaAlumno> getMatriculasByAlumno(@PathVariable String codigo)
    {
        List<Matricula> matriculaList = matriculaRepository.obtenerMatriculasAlumno(codigo);

        List<MatriculaAlumno> matriculaAlumnoList = new ArrayList<MatriculaAlumno>();

        for(Matricula list : matriculaList) {
            MatriculaAlumno matriculaAlumno = new MatriculaAlumno();
            matriculaAlumno.setFecha(list.getFechaMatricula());
            matriculaAlumno.setIdMatricula(list.getId());

            Alumno alumno = alumnoService.getAlumno(list.getIdAlumno()).get();
            matriculaAlumno.setAlumno(alumno);

            Curso curso = cursoService.getCurso(list.getIdCurso()).get();
            matriculaAlumno.setCurso(curso);

            matriculaAlumnoList.add(matriculaAlumno);
        }

        return matriculaAlumnoList;
    }

    @PostMapping("/matricula/alumno")
    public Matricula save(@RequestBody Matricula newMatricula)
    {
        Matricula matricula = new Matricula();
        matricula.setFechaMatricula(new Date());
        matricula.setIdAlumno(newMatricula.getIdAlumno());
        matricula.setIdCurso(newMatricula.getIdCurso());
        matriculaRepository.save(matricula);
        return matricula;
    }


}
