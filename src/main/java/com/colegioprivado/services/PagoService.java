package com.colegioprivado.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegioprivado.models.PagoModel;
import com.colegioprivado.repository.PagoRepository;

@Service
public class PagoService {
    @Autowired
    private PagoRepository repository;

    public List<PagoModel> listar() {
        return repository.findAll();
    }

    public Optional<PagoModel> buscar(Long id) {
        return repository.findById(id);
    }

    public PagoModel guardar(PagoModel p) {
        return repository.save(p);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
