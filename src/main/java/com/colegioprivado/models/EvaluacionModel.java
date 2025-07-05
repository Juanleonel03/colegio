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
@Table(name = "EVALUACION")
public class EvaluacionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evaluacion_seq")
    @SequenceGenerator(name = "evaluacion_seq", sequenceName = "SEQ_EVALUACION", allocationSize = 1)
    @Column(name = "ID_EVALUACION")
    private Long id_evaluacion;

    @ManyToOne
    @JoinColumn(name = "ID_ESTUDIANTE")
    private EstudianteModel id_estudiante;

    @ManyToOne
    @JoinColumn(name = "ID_CURSO")
    private CursoModel id_curso;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO")
    private TipoEvaluacionModel id_tipo;

    @Column(name = "NOTA")
    private Double nota;

    @Column(name = "FECHA_EVAL")
    private LocalDate fecha_eval;
}
