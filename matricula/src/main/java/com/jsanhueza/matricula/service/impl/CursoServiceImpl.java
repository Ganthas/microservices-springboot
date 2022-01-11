package com.jsanhueza.matricula.service.impl;

import com.jsanhueza.matricula.clients.CursoFeignClient;
import com.jsanhueza.matricula.model.Curso;
import com.jsanhueza.matricula.service.CursoService;
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
