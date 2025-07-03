package com.colegioprivado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.colegioprivado.models.EstudianteModel;

@Repository
public interface EstudianteRepository extends JpaRepository<EstudianteModel, Long> {

    @Query(value = "SELECT * FROM Estudiantes WHERE nombre = :nombre", nativeQuery = true)
    List<EstudianteModel> findByNombre(@Param("nombre") String nombre);

    @Query(value = "SELECT * FROM Estudiantes WHERE cedula = :cedula", nativeQuery = true)
    List<EstudianteModel> findByCedula(@Param("cedula") String cedula);

    @Query(value = "SELECT * FROM Estudiantes WHERE correo = :correo", nativeQuery = true)
    List<EstudianteModel> findByCorreo(@Param("correo") String correo);
}
