package com.colegioprivado.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.colegioprivado.models.CursoModel;

@Repository
public interface CursoRepository extends JpaRepository<CursoModel, Long> {
    @Query(value = "SELECT * FROM Curso WHERE nombre = :nombre", nativeQuery = true)
    List<CursoModel> findByNombre(@Param("nombre") String nombre);
}
