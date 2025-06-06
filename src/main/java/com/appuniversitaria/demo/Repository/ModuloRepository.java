package com.appuniversitaria.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.appuniversitaria.demo.Models.Modulo;
import java.util.List;

public interface ModuloRepository extends JpaRepository<Modulo, Integer> {

    @Query("SELECT m.titulo, m.contenido, m.fechaCreate, m.fechaDelete, m.imagenPath, t.nombre " +
           "FROM Modulo m LEFT JOIN m.topico t")

    List<Object[]> findAllWithTopicos();


}