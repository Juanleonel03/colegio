package com.colegioprivado.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colegioprivado.models.EstudianteModel;
import com.colegioprivado.repository.EstudianteRepository;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository repo;

    public List<EstudianteModel> listarTodos() {
        return repo.findAll();
    }

    public EstudianteModel guardar(EstudianteModel est) {
        return repo.save(est);
    }

    public Optional<EstudianteModel> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }

    public List<EstudianteModel> buscarPorCedula(String cedula){
        return repo.findByCedula(cedula);
    }

    public List<EstudianteModel> buscarPorNombre(String nombre){
        return repo.findByNombre(nombre);
    }

    public List<EstudianteModel> buscarPorCorreo(String correo){
        return repo.findByNombre(correo);
    }
}

