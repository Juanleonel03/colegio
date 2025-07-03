package com.colegioprivado.controllers;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.colegioprivado.models.ProfesorModel;
import com.colegioprivado.services.ProfesorService;

@RestController
@RequestMapping("/api/profesores")
@CrossOrigin(origins = "*")
public class ProfesorController {
    @Autowired
    private ProfesorService service;

    @GetMapping
    public List<ProfesorModel> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public ProfesorModel guardar(@RequestBody ProfesorModel prof) {
        return service.guardar(prof);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ProfesorModel> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<ProfesorModel>> buscarNombre(@PathVariable String nombre){
        List<ProfesorModel> profesores = service.buscarPorNombre(nombre);
        return !profesores.isEmpty() ? ResponseEntity.ok(profesores) : ResponseEntity.notFound().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProfesorModel> actualizar(@PathVariable Long id, @RequestBody Map<String, Object> campos) {
        return service.buscarPorId(id).map(prof -> {
            if (campos.containsKey("nombre")) prof.setNombre((String) campos.get("nombre"));
            if (campos.containsKey("especialidad")) prof.setEspecialidad((String) campos.get("especialidad"));
            if (campos.containsKey("correo")) prof.setCorreo((String) campos.get("correo"));
            return ResponseEntity.ok(service.guardar(prof));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
