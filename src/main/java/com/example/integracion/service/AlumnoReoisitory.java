package com.example.integracion.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.integracion.models.Alumno;

@Repository
public interface AlumnoReoisitory extends JpaRepository<Alumno, Long> {
    // Puedes agregar métodos personalizados para consultas adicionales si es necesario
}
