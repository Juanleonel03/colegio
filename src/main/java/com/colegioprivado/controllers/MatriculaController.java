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

import com.colegioprivado.models.MatriculaModel;
import com.colegioprivado.services.MatriculaService;

@RestController
@RequestMapping("/api/matriculas")
@CrossOrigin(origins = "*")
public class MatriculaController {
    @Autowired
    private MatriculaService service;

    @GetMapping
    public List<MatriculaModel> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatriculaModel> buscar(@PathVariable Long id) {
        return service.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MatriculaModel guardar(@RequestBody MatriculaModel m) {
        return service.guardar(m);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MatriculaModel> actualizar(@PathVariable Long id, @RequestBody MatriculaModel nuevo) {
        
        return service.buscar(id)
                .map(mat -> {
                    mat.setId_estudiante(nuevo.getId_estudiante());
                    mat.setId_curso(nuevo.getId_curso());
                    mat.setFecha(nuevo.getFecha());
                    mat.setEstado(nuevo.getEstado());
                    return ResponseEntity.ok(service.guardar(mat));
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
