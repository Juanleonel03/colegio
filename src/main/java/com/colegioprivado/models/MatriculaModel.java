package com.colegioprivado.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Matricula")
public class MatriculaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "matricula_seq")
    @SequenceGenerator(name = "matricula_seq", sequenceName = "SEQ_MATRICULA", allocationSize = 1)
    @Column(name = "ID_MATRICULA")
    private Long id_matricula;

    @ManyToOne
    @JoinColumn(name = "ID_ESTUDIANTE")
    private EstudianteModel id_estudiante;

    @ManyToOne
    @JoinColumn(name = "ID_CURSO")
    private CursoModel id_curso;

    @Column(name = "FECHA")
    private LocalDate fecha;

    @Column(name = "ESTADO")
    private String estado;

    public Long getId_matricula() {
        return id_matricula;
    }

    public void setId_matricula(Long id_matricula) {
        this.id_matricula = id_matricula;
    }

    public EstudianteModel getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(EstudianteModel id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public CursoModel getId_curso() {
        return id_curso;
    }

    public void setId_curso(CursoModel id_curso) {
        this.id_curso = id_curso;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
