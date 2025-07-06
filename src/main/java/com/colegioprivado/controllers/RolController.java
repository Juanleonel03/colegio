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

import com.colegioprivado.models.RolModel;
import com.colegioprivado.services.RolService;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "http://localhost:8100", allowCredentials = "true")
public class RolController {
    @Autowired
    private RolService service;

    @GetMapping
    public List<RolModel> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolModel> buscar(@PathVariable Long id) {
        return service.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RolModel guardar(@RequestBody RolModel r) {
        return service.guardar(r);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RolModel> actualizar(@PathVariable Long id, @RequestBody RolModel nuevo) {
        return service.buscar(id)
                .map(r -> {
                    r.setNombre_rol(nuevo.getNombre_rol());
                    return ResponseEntity.ok(service.guardar(r));
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

