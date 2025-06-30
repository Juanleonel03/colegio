package com.colegioprivado.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Estudiantes")
public class EstudianteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estudiante_seq")
    @SequenceGenerator(name = "estudiante_seq", sequenceName = "SEQ_ESTUDIANTE", allocationSize = 1)
    private Long id_estudiante;

    @Column(name = "nombre")
    private String nombre;

    
    @Column(name = "cedula", unique = true)
    private String cedula;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_nac", nullable = false)
    private LocalDate fecha_nac;

    @Column(name = "correo")
    private String correo;

    public Long getIdEstudiante() {
        return id_estudiante;
    }

    public void setIdEstudiante(Long id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public LocalDate getFechaNac() {
        return fecha_nac;
    }

    public void setFechaNac(LocalDate fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "EstudianteModel [id_estudiante=" + id_estudiante + ", nombre=" + nombre + ", cedula=" + cedula
                + ", fecha_nac=" + fecha_nac + ", correo=" + correo + "]";
    }

}
