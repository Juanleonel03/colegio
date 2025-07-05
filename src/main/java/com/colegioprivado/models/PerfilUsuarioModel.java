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
@Table(name = "PERFILUSUARIO")
public class PerfilUsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perfil_seq")
    @SequenceGenerator(name = "perfil_seq", sequenceName = "SEQ_PERFIL", allocationSize = 1)
    @Column(name = "ID_PERFIL")
    private Long id_perfil;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private UsuarioSistemaModel usuario;

    @ManyToOne
    @JoinColumn(name = "ID_ROL")
    private RolModel id_rol;

    @Column(name = "FECHA_CREADO")
    private LocalDate fecha_creado;

    public Long getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(Long id_perfil) {
        this.id_perfil = id_perfil;
    }

    public UsuarioSistemaModel getId_usuario() {
        return usuario;
    }

    public void setId_usuario(UsuarioSistemaModel id_usuario) {
        this.usuario = id_usuario;
    }

    public RolModel getId_rol() {
        return id_rol;
    }

    public void setId_rol(RolModel id_rol) {
        this.id_rol = id_rol;
    }

    public LocalDate getFecha_creado() {
        return fecha_creado;
    }

    public void setFecha_creado(LocalDate fecha_creado) {
        this.fecha_creado = fecha_creado;
    }

    
}
