package com.colegioprivado.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Curso")
public class CursoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso_seq")
    @SequenceGenerator(name = "curso_seq", sequenceName = "SEQ_CURSO", allocationSize = 1)
    private Long id_curso;
    private String nombre;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private ProfesorModel profesor;

    public Long getIdCurso() {
        return id_curso;
    }

    public void setIdCurso(Long id_curso) {
        this.id_curso = id_curso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ProfesorModel getProfesor() {
        return profesor;
    }

    public void setProfesor(ProfesorModel profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return "CursoModel [id_curso=" + id_curso + ", nombre=" + nombre + ", descripcion=" + descripcion + ", profesor="
                + profesor + "]";
    }

}
