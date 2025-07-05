package com.colegioprivado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.colegioprivado.models.RolModel;

@Repository
public interface RolRepository extends JpaRepository<RolModel, Long> {
    @Query(value = "SELECT * FROM Rol WHERE nombre_rol = :nombre_rol", nativeQuery = true)
    List<RolModel> findByNombre(@Param("nombre_rol") String nombre_rol);
}
