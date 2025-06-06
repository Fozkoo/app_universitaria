package com.appuniversitaria.demo.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ModuloRequest {

    private String titulo;
    private String contenido;
    private LocalDateTime fecha_create;
    private String imagen_path;
    private Integer topico_idtopicos;


}
