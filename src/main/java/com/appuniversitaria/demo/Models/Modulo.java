package com.appuniversitaria.demo.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "modulo")
@Getter
@Setter
public class Modulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idmodulo;

    private String titulo;

    @Column(name = "imagen_path")
    private String imagenPath;

    @Column(columnDefinition = "TEXT")
    private String contenido;

    private LocalDateTime fechaCreate;

    private LocalDateTime fechaDelete;

    @ManyToOne
    @JoinColumn(name = "topicos_idtopicos", referencedColumnName = "idtopicos")
    private Topicos topico;



}
