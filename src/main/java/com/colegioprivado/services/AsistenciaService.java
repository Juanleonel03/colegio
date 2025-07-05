package com.colegioprivado.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegioprivado.models.AsistenciaModel;
import com.colegioprivado.repository.AsistenciaRepository;

@Service
public class AsistenciaService {
    @Autowired
    private AsistenciaRepository repository;

    public List<AsistenciaModel> listar() {
        return repository.findAll();
    }

    public Optional<AsistenciaModel> buscar(Long id) {
        return repository.findById(id);
    }

    public AsistenciaModel guardar(AsistenciaModel a) {
        return repository.save(a);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
