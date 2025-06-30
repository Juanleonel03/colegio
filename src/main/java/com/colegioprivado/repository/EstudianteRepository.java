package com.colegioprivado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.colegioprivado.models.EstudianteModel;

@Repository
public interface EstudianteRepository extends JpaRepository<EstudianteModel, Long> {

    @Query(value = "SELECT * FROM estudiante WHERE nombre = :nombre", nativeQuery = true)
    List<EstudianteModel> findByNombre(@Param("nombre") String nombre);

    @Query(value = "SELECT * FROM estudiante WHERE cedula = :cedula", nativeQuery = true)
    List<EstudianteModel> findByCedula(@Param("nombre") String nombre);

    @Query(value = "SELECT * FROM estudiante WHERE correo = :correo", nativeQuery = true)
    List<EstudianteModel> findByCorreo(@Param("nombre") String nombre);
}
