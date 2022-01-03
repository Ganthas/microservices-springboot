package com.jsanhueza.curso.service.impl;

import com.jsanhueza.curso.model.Curso;
import com.jsanhueza.curso.repository.CursoRepository;
import com.jsanhueza.curso.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoImpl implements CursoService {

    @Autowired
    CursoRepository cursoRepository;

    @Override
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public String delete(Integer id) {
        if(id != null) {
            Boolean result = cursoRepository.existsById(id);
            if(result) {
                cursoRepository.deleteById(id);
                return "Eliminado exitosamente";
            }
            return "id no valido";
        }

        return "Proporcione un id";
    }

    @Override
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso findById(Integer codigo) {
        Curso curso = new Curso();
        Optional<Curso> cursoOptional = cursoRepository.findById(codigo);

        if(!cursoOptional.isEmpty()){
            curso = cursoOptional.get();
        }

        return curso;
    }
}
