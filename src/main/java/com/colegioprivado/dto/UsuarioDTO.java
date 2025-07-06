package com.colegioprivado.dto;

public class UsuarioDTO {
    private Long id_usuario;
    private String nombre;
    private String correo;
    private String username;
    private String rol;

    public UsuarioDTO(Long id_usuario, String nombre, String correo, String username, String rol) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.correo = correo;
        this.username = username;
        this.rol = rol;
    }

    // Getters y setters
    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}

