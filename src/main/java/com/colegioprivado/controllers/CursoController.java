package com.colegioprivado.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.colegioprivado.models.CursoModel;
import com.colegioprivado.services.CursoService;

@RestController
@RequestMapping("/api/cursos")
@CrossOrigin(origins = "*")
public class CursoController {
    @Autowired
    private CursoService service;

    @GetMapping
    public List<CursoModel> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public CursoModel guardar(@RequestBody CursoModel curso) {
        return service.guardar(curso);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<CursoModel> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<CursoModel>> buscarNombre(@PathVariable String nombre){
        List<CursoModel> cursos = service.buscarPorNombre(nombre);
        return !cursos.isEmpty() ? ResponseEntity.ok(cursos) : ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CursoModel> actualizar(@PathVariable Long id, @RequestBody Map<String, Object> campos) {
        return service.buscarPorId(id).map(curso -> {
            if (campos.containsKey("nombre")) curso.setNombre((String) campos.get("nombre"));
            if (campos.containsKey("descripcion")) curso.setDescripcion((String) campos.get("descripcion"));
            return ResponseEntity.ok(service.guardar(curso));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
