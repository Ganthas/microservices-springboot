package com.jsanhueza.matricula.service;


import com.jsanhueza.matricula.model.Matricula;

import java.util.List;

public interface MatriculaService {
	
	List<Matricula> obtenerMatricula(String codUser);
}
