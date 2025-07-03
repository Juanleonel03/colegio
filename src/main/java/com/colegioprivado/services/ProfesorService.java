package com.colegioprivado.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegioprivado.models.ProfesorModel;
import com.colegioprivado.repository.ProfesorRepository;

@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository repo;

    public List<ProfesorModel> listarTodos() {
        return repo.findAll();
    }

    public ProfesorModel guardar(ProfesorModel prof) {
        return repo.save(prof);
    }

    public Optional<ProfesorModel> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    public List<ProfesorModel> buscarPorNombre(String nombre){
        return repo.findByNombre(nombre);
    }
}
