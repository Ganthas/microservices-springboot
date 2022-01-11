package com.jsanhueza.composer.composer;

import java.util.ArrayList;
import java.util.List;

import com.jsanhueza.composer.models.*;
import com.jsanhueza.composer.service.AlumnoService;
import com.jsanhueza.composer.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsanhueza.composer.service.MatriculaService;

@Component
public class MatriculaALumnoComposer {

	@Autowired
	private AlumnoService alumnoService;

	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private MatriculaService matriculaService;
	
	public List<MatriculaAlumno> parserMatriculaAlumno(String codUser) {
		List<Matricula> matriculaList = matriculaService.obtenerMatricula(codUser);

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
}
