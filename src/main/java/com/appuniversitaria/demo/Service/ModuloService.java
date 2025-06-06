package com.appuniversitaria.demo.Service;

import com.appuniversitaria.demo.DTO.ModuloDTO;
import com.appuniversitaria.demo.DTO.ModuloRequest;
import com.appuniversitaria.demo.Models.Modulo;
import com.appuniversitaria.demo.Models.Topicos;
import com.appuniversitaria.demo.Repository.ModuloRepository;
import com.appuniversitaria.demo.Repository.TopicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModuloService {

    @Autowired
    private ModuloRepository moduloRepository;
    @Autowired
    private TopicosRepository topicosRepository;

    public List<ModuloDTO> getAllModulosWithTopicos() {
        return moduloRepository.findAllWithTopicos().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ModuloDTO convertToDTO(Object[] result) {
        ModuloDTO dto = new ModuloDTO();
        dto.setTitulo((String) result[0]);
        dto.setContenido((String) result[1]);
        dto.setFecha_create((LocalDateTime) result[2]);
        dto.setFecha_delete((LocalDateTime) result[3]);
        dto.setImagen_path((String) result[4]);
        dto.setTopico_nombre((String) result[5]);
        return dto;
    }


    public ModuloDTO createModulo(ModuloRequest moduloRequest) {
        Topicos topico = topicosRepository.findById(Long.valueOf(moduloRequest.getTopico_idtopicos()))
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));

        Modulo nuevoModulo = new Modulo();
        nuevoModulo.setTitulo(moduloRequest.getTitulo());
        nuevoModulo.setContenido(moduloRequest.getContenido());
        nuevoModulo.setFechaCreate(moduloRequest.getFecha_create());
        nuevoModulo.setImagenPath(moduloRequest.getImagen_path());
        nuevoModulo.setTopico(topico);

        Modulo moduloGuardado = moduloRepository.save(nuevoModulo);

        return convertToModuloDTO(moduloGuardado);
    }

    private ModuloDTO convertToModuloDTO(Modulo modulo) {
        ModuloDTO dto = new ModuloDTO();
        dto.setTitulo(modulo.getTitulo());
        dto.setContenido(modulo.getContenido());
        dto.setFecha_create(modulo.getFechaCreate());
        dto.setImagen_path(modulo.getImagenPath());
        dto.setTopico_nombre(modulo.getTopico() != null ? modulo.getTopico().getNombre() : null);
        return dto;
    }


}