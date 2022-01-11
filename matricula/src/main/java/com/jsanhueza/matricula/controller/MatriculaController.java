package com.jsanhueza.matricula.controller;

import com.jsanhueza.matricula.model.Alumno;
import com.jsanhueza.matricula.model.Matricula;
import com.jsanhueza.matricula.repository.MatriculaRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
    public List<Matricula> getMatriculasByAlumno(@PathVariable String codigo)
    {
        return matriculaRepository.obtenerMatriculasAlumno(codigo);
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
