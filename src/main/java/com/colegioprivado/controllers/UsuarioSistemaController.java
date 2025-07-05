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

import com.colegioprivado.models.UsuarioSistemaModel;
import com.colegioprivado.services.UsuarioSistemaService;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioSistemaController {
    @Autowired
    private UsuarioSistemaService service;

    @GetMapping
    public List<UsuarioSistemaModel> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioSistemaModel> buscar(@PathVariable Long id) {
        return service.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public UsuarioSistemaModel guardar(@RequestBody UsuarioSistemaModel u) {
        return service.guardar(u);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UsuarioSistemaModel> actualizar(@PathVariable Long id, @RequestBody UsuarioSistemaModel nuevo) {
        return service.buscar(id)
                .map(u -> {
                    u.setUsername(nuevo.getUsername());
                    u.setPassword(nuevo.getPassword());
                    u.setNombre(nuevo.getNombre());
                    u.setCorreo(nuevo.getCorreo());
                    return ResponseEntity.ok(service.guardar(u));
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
