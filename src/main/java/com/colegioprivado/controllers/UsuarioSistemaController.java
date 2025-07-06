package com.colegioprivado.controllers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

import com.colegioprivado.dto.UsuarioDTO;
import com.colegioprivado.models.UsuarioSistemaModel;
import com.colegioprivado.services.UsuarioSistemaService;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:8100", allowCredentials = "true")
public class UsuarioSistemaController {
    @Autowired
    private UsuarioSistemaService service;

    @GetMapping
    public List<UsuarioSistemaModel> listar() {
        return service.listar();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UsuarioSistemaModel> buscar(@PathVariable Long id) {
        return service.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/correo/{correo}")
    public ResponseEntity<List<UsuarioDTO>> buscarPorCorreo(@PathVariable String correo) {
        List<UsuarioSistemaModel> usuarios = service.buscarPorCorreo(correo);

        List<UsuarioDTO> dtoList = usuarios.stream().map(usuario -> new UsuarioDTO(
                usuario.getId_usuario(),
                usuario.getNombre(),
                usuario.getCorreo(),
                usuario.getUsername(),
                usuario.getPerfil().getId_rol().getNombre_rol())).collect(Collectors.toList());

        return ResponseEntity.ok(dtoList);
    }

    @PostMapping
    public UsuarioSistemaModel guardar(@RequestBody UsuarioSistemaModel u) {
        return service.guardar(u);
    }

    @PatchMapping("/id/{id}")
    public ResponseEntity<UsuarioSistemaModel> actualizar(
            @PathVariable Long id,
            @RequestBody Map<String, Object> camposActualizados) {
        return service.buscar(id)
                .map(u -> {
                    if (camposActualizados.containsKey("username")) {
                        u.setUsername((String) camposActualizados.get("username"));
                    }
                    if (camposActualizados.containsKey("nombre")) {
                        u.setNombre((String) camposActualizados.get("nombre"));
                    }
                    if (camposActualizados.containsKey("password")) {
                        u.setPassword((String) camposActualizados.get("password"));
                    }
                    if (camposActualizados.containsKey("correo")) {
                        u.setCorreo((String) camposActualizados.get("correo"));
                    }
                    return ResponseEntity.ok(service.guardar(u));
                }).orElse(ResponseEntity.notFound().build());
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
