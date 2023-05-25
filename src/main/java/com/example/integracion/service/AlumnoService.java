package com.example.integracion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.integracion.models.Alumno;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class AlumnoService {
    private static final Logger logger = Logger.getLogger(AlumnoService.class.getName());

    private final AlumnoReoisitory alumnoRepository;

    @Autowired
    public AlumnoService(AlumnoReoisitory alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    public Alumno guardarAlumno(Alumno alumno) {
        Alumno alumnoGuardado = alumnoRepository.save(alumno);
        logger.info("Alumno guardado en la base de datos: " + alumno.toString());
        return alumnoGuardado;
    }

    public Alumno buscarAlumnoPorId(Long id) {
        Optional<Alumno> alumnoOptional = alumnoRepository.findById(id);
        if (alumnoOptional.isPresent()) {
            Alumno alumno = alumnoOptional.get();
            logger.info("Alumno encontrado en la base de datos: " + alumno.toString());
            return alumno;
        } else {
            logger.info("Alumno no encontrado en la base de datos");
            return null;
        }
    }

    public List<Alumno> obtenerTodosLosAlumnos() {
        List<Alumno> alumnos = alumnoRepository.findAll();
        logger.info("Lista de alumnos obtenida de la base de datos: " + alumnos.toString());
        return alumnos;
    }

    public void actualizarAlumno(Alumno alumno) {
        alumnoRepository.save(alumno);
        logger.info("Alumno actualizado en la base de datos: " + alumno.toString());
    }

    public void eliminarAlumnoPorId(Long id) {
        alumnoRepository.deleteById(id);
        logger.info("Alumno eliminado de la base de datos. ID: " + id);
    }
}

