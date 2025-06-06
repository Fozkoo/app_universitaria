package com.appuniversitaria.demo.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ModuloDTO {

    private String titulo;
    private String contenido;
    private LocalDateTime fecha_create;
    private LocalDateTime fecha_delete;
    private String imagen_path;
    private String topico_nombre;


}
