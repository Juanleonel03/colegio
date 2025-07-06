package com.colegioprivado.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegioprivado.models.PerfilUsuarioModel;
import com.colegioprivado.services.PerfilUsuarioService;

@RestController
@RequestMapping("/api/perfiles")
@CrossOrigin(origins = "http://localhost:8100", allowCredentials = "true")
public class PerfilUsuarioController {
    @Autowired
    private PerfilUsuarioService service;

    @GetMapping
    public List<PerfilUsuarioModel> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerfilUsuarioModel> buscar(@PathVariable Long id) {
        return service.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PerfilUsuarioModel guardar(@RequestBody PerfilUsuarioModel p) {
        return service.guardar(p);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PerfilUsuarioModel> actualizar(@PathVariable Long id, @RequestBody PerfilUsuarioModel nuevo) {
        return service.buscar(id)
                .map(p -> {
                    p.setId_usuario(nuevo.getId_usuario());
                    p.setId_rol(nuevo.getId_rol());
                    p.setFecha_creado(nuevo.getFecha_creado());
                    return ResponseEntity.ok(service.guardar(p));

                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (service.buscar(id).isPresent()) {
            service.eliminar(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}