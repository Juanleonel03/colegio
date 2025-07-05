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

import com.colegioprivado.models.AsistenciaModel;
import com.colegioprivado.services.AsistenciaService;

@RestController
@RequestMapping("/api/asistencias")
@CrossOrigin(origins = "*")
public class AsistenciaController {
    @Autowired
    private AsistenciaService service;

    @GetMapping
    public List<AsistenciaModel> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsistenciaModel> buscar(@PathVariable Long id) {
        return service.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AsistenciaModel guardar(@RequestBody AsistenciaModel a) {
        return service.guardar(a);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AsistenciaModel> actualizar(@PathVariable Long id, @RequestBody AsistenciaModel nuevo) {
        return service.buscar(id)
                .map(a -> {
                    a.setId_estudiante(nuevo.getId_estudiante());
                    a.setId_curso(nuevo.getId_curso());
                    a.setFecha(nuevo.getFecha());
                    a.setEstado(nuevo.getEstado());
                    return ResponseEntity.ok(service.guardar(a));
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

