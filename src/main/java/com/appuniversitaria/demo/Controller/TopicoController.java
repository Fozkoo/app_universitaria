package com.appuniversitaria.demo.Controller;


import com.appuniversitaria.demo.Models.Topicos;
import com.appuniversitaria.demo.Repository.TopicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topicos/")
public class TopicoController {


    @Autowired
    private TopicosRepository topicosRepository;

    @CrossOrigin
    @GetMapping("/getAllTopicos")
    public List<Topicos> getAllTopicos(){
        return topicosRepository.findAll();
    }

    @CrossOrigin
    @PostMapping("/createTopico")
    public ResponseEntity<Topicos> createTopico(@RequestBody Topicos topico){
        topicosRepository.save(topico);
        return new ResponseEntity<>(topico, HttpStatus.CREATED);
    }


}
