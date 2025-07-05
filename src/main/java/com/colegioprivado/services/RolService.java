package com.colegioprivado.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegioprivado.models.RolModel;
import com.colegioprivado.repository.RolRepository;

@Service
public class RolService {
    @Autowired
    private RolRepository repository;

    public List<RolModel> listar() {
        return repository.findAll();
    }

    public Optional<RolModel> buscar(Long id) {
        return repository.findById(id);
    }

    public RolModel guardar(RolModel r) {
        return repository.save(r);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public List<RolModel> buscarNombre(String nombre_rol){
        return repository.findByNombre(nombre_rol);
    }
}