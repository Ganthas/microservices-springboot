package com.jsanhueza.composer.service.impl;

import java.util.List;

import com.jsanhueza.composer.clients.MatriculaFeignClient;
import com.jsanhueza.composer.models.Matricula;
import com.jsanhueza.composer.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaServiceImp implements MatriculaService {
	
	@Autowired
	private MatriculaFeignClient matriculaFeignClient;

	@Override
	public List<Matricula> obtenerMatricula(String codUser)  {
		return matriculaFeignClient.getMatriculaAlumno(codUser);
	}
}
