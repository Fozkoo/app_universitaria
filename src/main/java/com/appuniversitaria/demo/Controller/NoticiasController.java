package com.appuniversitaria.demo.Controller;

import com.appuniversitaria.demo.Models.Noticias;
import com.appuniversitaria.demo.Repository.NoticiasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/noticias")
public class NoticiasController {

    @Autowired
    private NoticiasRepository noticiasRepository;

    @CrossOrigin
    @GetMapping("/getAllNoticias")
    public List<Noticias> getAllNoticias(){
        return noticiasRepository.findAll();
    }

    @CrossOrigin
    @PostMapping("/create")
    public Noticias createNoticias(@RequestBody Noticias n){
        return noticiasRepository.save(n);
    }







}
