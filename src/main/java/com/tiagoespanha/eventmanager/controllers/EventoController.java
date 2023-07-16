package com.tiagoespanha.eventmanager.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tiagoespanha.eventmanager.entities.Evento;
import com.tiagoespanha.eventmanager.entities.Usuario;
import com.tiagoespanha.eventmanager.repositories.EventoRepository;
import com.tiagoespanha.eventmanager.repositories.UsuarioRepository;

@RestController
@RequestMapping(value = "/eventos")
public class EventoController {
    
    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/teste")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", name);
    }

    @PostMapping("")
    public String criarEvento(
    @RequestHeader("usuarioId") Long usuarioId,
    @RequestBody Evento novoEvento) 
    {   
        Usuario usuarioAtual;
        try {
            usuarioAtual = usuarioRepository.findById(usuarioId).orElseThrow();
        }
        catch(Exception err) {
            return "Usuário não encontrado";
        }
       
        if (usuarioAtual == null || usuarioAtual.getAdmin() == false) {
            return "Usuário precisa ser administrador";
        }

        try {
            eventoRepository.save(novoEvento);
            return "Sucesso";
        } 
        catch(Exception err) {
            return "Falha";
        }
        
    }
}

