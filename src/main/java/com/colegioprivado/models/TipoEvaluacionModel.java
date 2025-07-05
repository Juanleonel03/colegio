package com.colegioprivado.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIPOEVALUACION")
public class TipoEvaluacionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipoEv_seq")
    @SequenceGenerator(name = "tipoEv_seq", sequenceName = "SEQ_TIPOEV", allocationSize = 1)
    @Column(name = "ID_TIPO")
    private Long id_tipo;

    @Column(name = "DESCRIPCION")
    private String descripcion;
}
