package com.colegioprivado.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegioprivado.models.PerfilUsuarioModel;
import com.colegioprivado.repository.PerfilUsuarioRepository;

@Service
public class PerfilUsuarioService {
    @Autowired
    private PerfilUsuarioRepository repository;

    public List<PerfilUsuarioModel> listar() {
        return repository.findAll();
    }

    public Optional<PerfilUsuarioModel> buscar(Long id) {
        return repository.findById(id);
    }

    public PerfilUsuarioModel guardar(PerfilUsuarioModel p) {
        return repository.save(p);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
