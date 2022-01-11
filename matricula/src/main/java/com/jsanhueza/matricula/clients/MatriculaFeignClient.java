package com.jsanhueza.matricula.clients;

import com.jsanhueza.matricula.model.Matricula;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "matricula.servicio")
public interface MatriculaFeignClient {
	
	@GetMapping("/matricula/alumno/{codUser}")
	public List<Matricula> getMatriculaAlumno(@PathVariable String codUser);
}

