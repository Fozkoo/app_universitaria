package com.appuniversitaria.demo.Controller;

import com.appuniversitaria.demo.DTO.ModuloDTO;
import com.appuniversitaria.demo.DTO.ModuloRequest;
import com.appuniversitaria.demo.Models.Modulo;
import com.appuniversitaria.demo.Repository.ModuloRepository;
import com.appuniversitaria.demo.Service.ModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modulo")
public class ModuloController {


    @Autowired
    private ModuloService moduloService;

    @CrossOrigin
    @GetMapping("/getAllModulos")
    public List<ModuloDTO> getAllModuloss() {
        return moduloService.getAllModulosWithTopicos();
    }

    @CrossOrigin
    @PostMapping("/create")
    public ResponseEntity<ModuloDTO> createModulo(@RequestBody ModuloRequest moduloRequest) {
        ModuloDTO nuevoModulo = moduloService.createModulo(moduloRequest);
        return new ResponseEntity<>(nuevoModulo, HttpStatus.CREATED);
    }


}
