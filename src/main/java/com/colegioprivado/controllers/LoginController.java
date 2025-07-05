package com.colegioprivado.controllers;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegioprivado.models.LoginModel;
import com.colegioprivado.models.PerfilUsuarioModel;
import com.colegioprivado.models.UsuarioSistemaModel;
import com.colegioprivado.repository.PerfilUsuarioRepository;
import com.colegioprivado.repository.UsuarioSistemaRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:8100", allowCredentials = "true")
public class LoginController {

    @Autowired
    private UsuarioSistemaRepository usuarioRepo;

    @Autowired
    private PerfilUsuarioRepository perfilRepo;

    /*
     * public ResponseEntity<?> login(@RequestBody LoginModel LoginModel) {
     * Optional<UsuarioSistemaModel> usuarioOpt =
     * usuarioRepo.findByUsernameAndPassword(
     * LoginModel.getUsername(), LoginModel.getPassword()
     * );
     * 
     * if (usuarioOpt.isPresent()) {
     * UsuarioSistemaModel usuario = usuarioOpt.get();
     * return ResponseEntity.ok(Map.of(
     * "token", "fake-jwt-token",
     * "rol", usuario.getPerfil().getId_rol().getNombre_rol()
     * ));
     * } else {
     * return ResponseEntity.status(HttpStatus.UNAUTHORIZED).
     * body("Credenciales inválidas 2");
     * }
     * }
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginModel loginModel) {
        Optional<UsuarioSistemaModel> usuarioOpt = usuarioRepo.findByUsernameAndPassword(
                loginModel.getUsername(), loginModel.getPassword());

        if (usuarioOpt.isPresent()) {
            UsuarioSistemaModel usuario = usuarioOpt.get();

            Optional<PerfilUsuarioModel> perfilOpt = perfilRepo.findByUsuario(usuario);

            if (perfilOpt.isPresent()) {
                String nombreRol = perfilOpt.get().getId_rol().getNombre_rol();

                return ResponseEntity.ok(Map.of(
                        "token", "fake-jwt-token",
                        "rol", nombreRol));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body("El usuario no tiene un perfil asignado.");
            }

        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Credenciales inválidas");
        }
    }

}
