package com.example.integracion.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Colegio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    
	@OneToMany(mappedBy = "colegio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alumno> alumnos = new ArrayList<>();

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	 public List<Alumno> getAlumnos() {
	        return alumnos;
	    }

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}



    // Constructor, getters y setters

    // Otros métodos
	
	

    public void addAlumno(Alumno alumno) {
        alumnos.add(alumno);
        alumno.setColegio(this);
    }

    public void removeAlumno(Alumno alumno) {
        alumnos.remove(alumno);
        alumno.setColegio(null);
    }
}

