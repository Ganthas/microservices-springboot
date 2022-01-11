package com.jsanhueza.composer.service.impl;

import com.jsanhueza.composer.clients.AlumnoFeignClient;
import com.jsanhueza.composer.models.Alumno;
import com.jsanhueza.composer.service.AlumnoService;
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
