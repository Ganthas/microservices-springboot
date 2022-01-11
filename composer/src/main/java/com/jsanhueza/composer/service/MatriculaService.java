package com.jsanhueza.composer.service;

import java.util.List;

import com.jsanhueza.composer.models.Matricula;

public interface MatriculaService {
	
	List<Matricula> obtenerMatricula(String codUser);
}
