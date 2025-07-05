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
@Table(name = "Asistencia")
public class AsistenciaModel {

    @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "asistencia_seq")
    @SequenceGenerator(name = "asistencia_seq", sequenceName = "SEQ_ASISTENCIA", allocationSize = 1)
    @Column(name = "ID_ASISTENCIA")
    private Long id_asistencia;

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

    public Long getId_asistencia() {
        return id_asistencia;
    }

    public void setId_asistencia(Long id_asistencia) {
        this.id_asistencia = id_asistencia;
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

