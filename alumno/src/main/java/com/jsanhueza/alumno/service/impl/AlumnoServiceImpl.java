package com.jsanhueza.alumno.service.impl;

import com.jsanhueza.alumno.model.Alumno;
import com.jsanhueza.alumno.repository.AlumnoRepository;
import com.jsanhueza.alumno.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    AlumnoRepository alumnoRepository;

    @Override
    public Alumno save(Alumno alumno) {
        return alumnoRepository.insert(alumno);
    }

    @Override
    public String delete(String id) {
        if(id != null) {
            Boolean result = alumnoRepository.existsById(id);
            if(result) {
                alumnoRepository.deleteById(id);
                return "Eliminado exitosamente";
            }
            return "id no valido";
        }

        return "Proporcione un id";
    }

    @Override
    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }
}
