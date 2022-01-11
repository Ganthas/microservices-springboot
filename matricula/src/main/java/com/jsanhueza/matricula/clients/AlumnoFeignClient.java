package com.jsanhueza.matricula.clients;

import com.jsanhueza.matricula.model.Alumno;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "alumno.servicio")
public interface AlumnoFeignClient {

	@GetMapping("/alumno/{codigo}")
	public Optional<Alumno> getAlumno(@PathVariable String codigo);
}
