package com.estudos.encriptarsenhausuario.controller;

import com.estudos.encriptarsenhausuario.model.UsuarioModel;
import com.estudos.encriptarsenhausuario.repository.UsuarioRepository;
import com.fasterxml.jackson.core.PrettyPrinter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<UsuarioModel>> listarTodos(){
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping("/salvar")
    public ResponseEntity<UsuarioModel> salvar(@RequestBody UsuarioModel usuario){
        return ResponseEntity.ok(repository.save(usuario));
    }

}
