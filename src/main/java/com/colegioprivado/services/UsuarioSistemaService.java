package com.colegioprivado.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegioprivado.models.UsuarioSistemaModel;
import com.colegioprivado.repository.UsuarioSistemaRepository;

@Service
public class UsuarioSistemaService {
    @Autowired
    private UsuarioSistemaRepository repository;

    public List<UsuarioSistemaModel> listar() {
        return repository.findAll();
    }

    public Optional<UsuarioSistemaModel> buscar(Long id) {
        return repository.findById(id);
    }

    public UsuarioSistemaModel guardar(UsuarioSistemaModel u) {
        return repository.save(u);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
