package com.jsanhueza.composer.service.impl;

import com.jsanhueza.composer.clients.AlumnoFeignClient;
import com.jsanhueza.composer.clients.CursoFeignClient;
import com.jsanhueza.composer.models.Curso;
import com.jsanhueza.composer.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoFeignClient cursoFeignClient;

    @Override
    public Optional<Curso> getCurso(Integer codigo) {
        return cursoFeignClient.getCurso(codigo);
    }
}
