package com.appuniversitaria.demo.Repository;

import com.appuniversitaria.demo.Models.Noticias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiasRepository extends JpaRepository<Noticias, Long> {
}
