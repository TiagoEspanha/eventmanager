package com.tiagoespanha.eventmanager.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping()
    public List<Usuario> listaUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios;
    }

    @DeleteMapping("/{id}")
    public String deleta(@PathVariable Long id) {
        Usuario usuario;
        try {
            usuario = usuarioRepository.findById(id).orElseThrow();
        } catch (Exception err) {
            return "Usuario não existe";
        }

        usuarioRepository.delete(usuario);

        return "Usuario deletada com sucesso";
    }

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
