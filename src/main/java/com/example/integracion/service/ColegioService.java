package com.example.integracion.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.integracion.models.Alumno;
import com.example.integracion.models.Colegio;

public interface ColegioService extends JpaRepository<Colegio, Long> {
}

// Puedes agregar métodos personalizados para consultas adicionales si es necesario













