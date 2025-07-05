package com.colegioprivado.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.colegioprivado.dto.RegistroDTO;
import com.colegioprivado.models.EstudianteModel;
import com.colegioprivado.models.PerfilUsuarioModel;
import com.colegioprivado.models.ProfesorModel;
import com.colegioprivado.models.RolModel;
import com.colegioprivado.models.UsuarioSistemaModel;
import com.colegioprivado.repository.EstudianteRepository;
import com.colegioprivado.repository.PerfilUsuarioRepository;
import com.colegioprivado.repository.ProfesorRepository;
import com.colegioprivado.repository.RolRepository;
import com.colegioprivado.repository.UsuarioSistemaRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class RegistroController {

    @Autowired
    private UsuarioSistemaRepository usuarioRepo;

    @Autowired
    private EstudianteRepository estudianteRepo;

    @Autowired
    private ProfesorRepository profesorRepo;

    @Autowired
    private RolRepository rolRepo;

    @Autowired
    private PerfilUsuarioRepository perfilRepo;

    @PostMapping("/register")
    public ResponseEntity<?> registrarUsuario(@RequestBody RegistroDTO dto) {


        String nombreRol = dto.getRol();
        System.out.println(dto.getRol());
        List<RolModel> roles = rolRepo.findByNombre(nombreRol);
        System.out.println(roles);
        if (roles.isEmpty()) {
            throw new RuntimeException("Rol no encontrado");
        }
        RolModel rol = roles.get(0); // usa el primero

        UsuarioSistemaModel usuario = new UsuarioSistemaModel();

        usuario.setNombre(dto.getNombre());
        usuario.setUsername(dto.getUsername());
        usuario.setPassword(dto.getPassword());
        usuario.setCorreo(dto.getCorreo());
        usuarioRepo.save(usuario);
        // Guardar en tabla correspondiente según rol
        switch (dto.getRol()) {
            case "Estudiante":
                EstudianteModel estudiante = new EstudianteModel();
                estudiante.setNombre(dto.getNombre());
                estudiante.setCedula(dto.getCedula());
                estudiante.setFechaNac(dto.getFecha_nac());
                estudiante.setCorreo(dto.getCorreo());
                estudianteRepo.save(estudiante);
                break;

            case "Profesor":
                ProfesorModel profesor = new ProfesorModel();
                profesor.setNombre(dto.getNombre());
                profesor.setEspecialidad("General"); // o como lo manejes
                profesor.setCorreo(dto.getCorreo());
                profesorRepo.save(profesor);
                break;

            default:
                return ResponseEntity.badRequest().body("Rol no válido");
        }

        PerfilUsuarioModel perfilUsuario = new PerfilUsuarioModel();

        perfilUsuario.setId_usuario(usuario); // ENTIDAD completa
        perfilUsuario.setId_rol(rol);
        perfilUsuario.setFecha_creado(java.time.LocalDate.now());
        perfilRepo.save(perfilUsuario);

        return ResponseEntity.ok("Registro exitoso");
    }

}
