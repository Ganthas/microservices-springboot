package com.jsanhueza.composer.clients;

import java.util.List;

import com.jsanhueza.composer.models.Matricula;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "matricula.servicio")
public interface MatriculaFeignClient {
	
	@GetMapping("/matricula/alumno/{codUser}")
	public List<Matricula> getMatriculaAlumno(@PathVariable String codUser);
}

