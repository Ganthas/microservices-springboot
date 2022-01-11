package com.jsanhueza.matricula.service.impl;

import com.jsanhueza.matricula.clients.MatriculaFeignClient;
import com.jsanhueza.matricula.model.Matricula;
import com.jsanhueza.matricula.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaServiceImp implements MatriculaService {
	
	@Autowired
	private MatriculaFeignClient matriculaFeignClient;

	@Override
	public List<Matricula> obtenerMatricula(String codUser)  {
		return matriculaFeignClient.getMatriculaAlumno(codUser);
	}
}
