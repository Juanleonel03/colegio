package com.colegioprivado.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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

import com.colegioprivado.models.EstudianteModel;
import com.colegioprivado.services.EstudianteService;

@RestController
@RequestMapping("/api/estudiantes")
@CrossOrigin(origins = "http://localhost:8100", allowCredentials = "true")
public class EstudianteController {
    @Autowired
    private EstudianteService service;

    @GetMapping
    public List<EstudianteModel> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public EstudianteModel guardar(@RequestBody EstudianteModel est) {
        return service.guardar(est);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<EstudianteModel> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cedula/{cedula}")
    public ResponseEntity<List<EstudianteModel>> buscarCedula(@PathVariable String cedula) {
        List<EstudianteModel> estudiante = service.buscarPorCedula(cedula);
        return !estudiante.isEmpty() ? ResponseEntity.ok(estudiante) : ResponseEntity.notFound().build();
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<EstudianteModel>> buscarNombre(@PathVariable String nombre){
        List<EstudianteModel> nombreEstudiante = service.buscarPorNombre(nombre);
        return !nombreEstudiante.isEmpty() ? ResponseEntity.ok(nombreEstudiante) : ResponseEntity.notFound().build();
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<List<EstudianteModel>> buscarPorCorreo(@PathVariable String correo){
        List<EstudianteModel> correoEstudiante = service.buscarPorCorreo(correo);
        return !correoEstudiante.isEmpty() ? ResponseEntity.ok(correoEstudiante) : ResponseEntity.notFound().build();
    }

    @PatchMapping("/id/{id}")
    public ResponseEntity<EstudianteModel> actualizar(
            @PathVariable Long id,
            @RequestBody Map<String, Object> camposActualizados) {

        return service.buscarPorId(id).map(est -> {
            if (camposActualizados.containsKey("nombre")) {
                est.setNombre((String) camposActualizados.get("nombre"));
            }
            if (camposActualizados.containsKey("cedula")) {
                est.setCedula((String) camposActualizados.get("cedula"));
            }
            if (camposActualizados.containsKey("correo")) {
                est.setCorreo((String) camposActualizados.get("correo"));
            }
            if (camposActualizados.containsKey("fecha_nac")) {
                est.setFechaNac(LocalDate.parse((String) camposActualizados.get("fecha_nac")));
            }

            return ResponseEntity.ok(service.guardar(est));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
