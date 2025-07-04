package com.colegioprivado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.colegioprivado.models.ProfesorModel;

@Repository
public interface ProfesorRepository extends JpaRepository<ProfesorModel, Long> {
    @Query(value = "SELECT * FROM Profesor WHERE nombre = :nombre", nativeQuery = true)
    List<ProfesorModel> findByNombre(@Param("nombre") String nombre);
}
