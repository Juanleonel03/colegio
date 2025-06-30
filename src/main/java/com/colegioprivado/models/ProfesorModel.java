package com.colegioprivado.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ProfesorModel {
    @Id
    @GeneratedValue
    private Long id_profesor;
    private String nombre;
    private String especialidad;
    private String correo;

    public Long getIdProfesor() {
        return id_profesor;
    }

    public void setIdProfesor(Long id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "ProfesorModel [idProfesor=" + id_profesor + ", nombre=" + nombre + ", especialidad=" + especialidad
                + ", correo=" + correo + "]";
    }

}
