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
@Table(name = "PAGO")
public class PagoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pago_seq")
    @SequenceGenerator(name = "pago_seq", sequenceName = "SEQ_PAGO", allocationSize = 1)
    @Column(name = "ID_PAGO")
    private Long id_pago;

    @ManyToOne
    @JoinColumn(name = "ID_ESTUDIANTE")
    private EstudianteModel id_estudiante;

    @Column(name = "MONTO")
    private Double monto;

    @Column(name = "FECHA_PAGO")
    private LocalDate fecha_pago;

    @Column(name = "METODO")
    private String metodo;

    public Long getId_pago() {
        return id_pago;
    }

    public void setId_pago(Long id_pago) {
        this.id_pago = id_pago;
    }

    public EstudianteModel getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(EstudianteModel id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public LocalDate getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(LocalDate fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }
}
