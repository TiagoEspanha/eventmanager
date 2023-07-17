package com.tiagoespanha.eventmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiagoespanha.eventmanager.entities.Evento;
import com.tiagoespanha.eventmanager.entities.Edicao;
import com.tiagoespanha.eventmanager.entities.Usuario;
import com.tiagoespanha.eventmanager.repositories.EventoRepository;
import com.tiagoespanha.eventmanager.repositories.UsuarioRepository;
import com.tiagoespanha.eventmanager.repositories.EdicaoRepository;

@RestController
@RequestMapping(value = "/edicoes")
public class EdicaoController {

    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private EdicaoRepository edicaoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @PostMapping("")
    public String criarEdicao(
        @RequestHeader("usuarioId") Long usuarioId,
        @RequestBody Edicao novaEdicao) {
            
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

            novaEdicao.setCriador(usuarioAtual);
            System.out.println(novaEdicao);
            Evento evento; 
            try {
                evento = eventoRepository.findById(novaEdicao.getEvento().getId()).orElseThrow();
            } catch(Exception err) {
                return "Evento não encontrado";
            }

            novaEdicao.setEvento(evento);
            edicaoRepository.save(novaEdicao);

            return "sucesso";

        }

}