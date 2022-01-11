package com.jsanhueza.matricula.service.impl;

import com.jsanhueza.matricula.clients.AlumnoFeignClient;
import com.jsanhueza.matricula.model.Alumno;
import com.jsanhueza.matricula.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoFeignClient alumnoFeignClient;

	@Override
	public Optional<Alumno> getAlumno(String codigo) {
		return alumnoFeignClient.getAlumno(codigo);
	}
}
