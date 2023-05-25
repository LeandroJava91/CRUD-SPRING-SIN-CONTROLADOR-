package com.example.integracion.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Alumno {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "colegio_id")
    @JsonProperty
    private Colegio colegio;

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

	public Colegio getColegio() {
		return colegio;
	}

	

    // Constructor, getters y setters

    // Otros métodos

    public void setColegio(Colegio colegio) {
        this.colegio = colegio;
        
    }
    

	@Override
	public String toString() {
		return "Alumno: id=" + id + ", nombre=" + nombre + ", colegio="+ colegio.getNombre()+"";
	}
}
