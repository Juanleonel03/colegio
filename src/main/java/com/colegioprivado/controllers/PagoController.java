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

import com.colegioprivado.models.PagoModel;
import com.colegioprivado.services.PagoService;

@RestController
@RequestMapping("/api/pagos")
@CrossOrigin(origins = "http://localhost:8100", allowCredentials = "true")
public class PagoController {
    @Autowired
    private PagoService service;

    @GetMapping
    public List<PagoModel> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoModel> buscar(@PathVariable Long id) {
        return service.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PagoModel guardar(@RequestBody PagoModel p) {
        return service.guardar(p);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PagoModel> actualizar(@PathVariable Long id, @RequestBody PagoModel nuevo) {
        return service.buscar(id)
                .map(p -> {
                    p.setId_estudiante(nuevo.getId_estudiante());
                    p.setMonto(nuevo.getMonto());
                    p.setFecha_pago(nuevo.getFecha_pago());
                    p.setMetodo(nuevo.getMetodo());
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
