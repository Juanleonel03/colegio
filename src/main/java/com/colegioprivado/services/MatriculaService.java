package com.colegioprivado.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegioprivado.models.MatriculaModel;
import com.colegioprivado.repository.MatriculaRepository;

@Service
public class MatriculaService {
    @Autowired
    private MatriculaRepository repository;

    public List<MatriculaModel> listar() {
        return repository.findAll();
    }

    public Optional<MatriculaModel> buscar(Long id) {
        return repository.findById(id);
    }

    public MatriculaModel guardar(MatriculaModel m) {
        return repository.save(m);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
