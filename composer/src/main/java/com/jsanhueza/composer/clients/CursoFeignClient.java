package com.jsanhueza.composer.clients;

import com.jsanhueza.composer.models.Curso;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "curso.servicio")
public interface CursoFeignClient {

    @GetMapping("/curso/{codigo}")
    public Optional<Curso> getCurso(@PathVariable Integer codigo);
}
