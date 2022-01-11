package com.jsanhueza.composer.controller;

import java.util.List;

import com.jsanhueza.composer.composer.MatriculaALumnoComposer;
import com.jsanhueza.composer.models.MatriculaAlumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComposerController {

	@Autowired
	private MatriculaALumnoComposer matriculaALumnoComposer;
	
	@GetMapping("/matricula/alumno/{codigo}")
	public List<MatriculaAlumno> getMatriculaAlumno(@PathVariable String codigo){
		return matriculaALumnoComposer.parserMatriculaAlumno(codigo);
	}
}
