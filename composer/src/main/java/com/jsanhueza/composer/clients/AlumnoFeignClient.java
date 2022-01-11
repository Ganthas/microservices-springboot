package com.jsanhueza.composer.clients;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.jsanhueza.composer.models.Alumno;

@FeignClient(name = "alumno.servicio")
public interface AlumnoFeignClient {

	@GetMapping("/alumno/{codigo}")
	public Optional<Alumno> getAlumno(@PathVariable String codigo);
}
