package com.appuniversitaria.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "topicos")
@Getter
@Setter
public class Topicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtopicos;

    private String nombre;

    private String descripcion;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Modulo> modulos;
}
