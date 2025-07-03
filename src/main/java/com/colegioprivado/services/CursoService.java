package com.colegioprivado.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegioprivado.models.CursoModel;
import com.colegioprivado.repository.CursoRepository;

@Service
public class CursoService {
    @Autowired
    private CursoRepository repo;

    public List<CursoModel> listarTodos() {
        return repo.findAll();
    }

    public CursoModel guardar(CursoModel curso) {
        return repo.save(curso);
    }

    public Optional<CursoModel> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    public List<CursoModel> buscarPorNombre(String nombre){
        return repo.findByNombre(nombre);
    }
}

