package com.tiagoespanha.eventmanager.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiagoespanha.eventmanager.entities.Usuario;
import com.tiagoespanha.eventmanager.repositories.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("")
    public String criarUsuario(@RequestBody Usuario novoUsuario) {
        try {
            usuarioRepository.save(novoUsuario);
            return "Sucesso";
        } 
        catch(Exception err) {
            return "Falha";
        }
    }
}
