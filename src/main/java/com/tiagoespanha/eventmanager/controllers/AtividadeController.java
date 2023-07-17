package com.tiagoespanha.eventmanager.controllers;

import java.util.List;

import com.tiagoespanha.eventmanager.entities.Edicao;
import com.tiagoespanha.eventmanager.entities.Atividade;
import com.tiagoespanha.eventmanager.entities.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiagoespanha.eventmanager.repositories.AtividadeRepository;
import com.tiagoespanha.eventmanager.repositories.EdicaoRepository;
import com.tiagoespanha.eventmanager.repositories.EventoRepository;
import com.tiagoespanha.eventmanager.repositories.UsuarioRepository;

@RestController
@RequestMapping(value = "/atividades")
public class AtividadeController {

    @Autowired
    private AtividadeRepository atividadeRepository;
    @Autowired
    private EventoRepository eventoRepository;
    @Autowired
    private EdicaoRepository edicaoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    


    @PostMapping("edicao/{edicaoId}")
    public String criar(
        @RequestHeader("usuarioId") Long usuarioId,
        @PathVariable Long edicaoId,
        @RequestBody Atividade novaAtividade){

        Usuario usuarioAtual;
        try {
            usuarioAtual = usuarioRepository.findById(usuarioId).orElseThrow();
        }
        catch(Exception err) {
            return "Usuário não encontrado";
        }

        Edicao edicao;
        try {
            edicao = edicaoRepository.findById(edicaoId).orElseThrow();
        }
        catch(Exception err) {
            return "Edicao não encontrado";
        }
    
        if (edicao == null || edicao.getOrganizador().getId() != usuarioAtual.getId()) {
            return "Usuário precisa ser organizador da edicao para criar atividade";
        }

        try {
            novaAtividade.setEdicao(edicao);
            atividadeRepository.save(novaAtividade);
            return "Sucesso";
        } catch (Exception err) {
            return "Falha";
        }
    }

    @PostMapping("{id}/favoritar")
    public String favoritar(
        @RequestHeader("usuarioId") Long usuarioId,
        @PathVariable Long id){

        Usuario usuarioAtual;
        try {
            usuarioAtual = usuarioRepository.findById(usuarioId).orElseThrow();
        }
        catch(Exception err) {
            return "Usuário não encontrado";
        }

        Atividade atividade;
        try {
            atividade = atividadeRepository.findById(id).orElseThrow();
        }
        catch(Exception err) {
            return "Atividade não encontrado";
        }
        
        
        List<Atividade> favoritos = usuarioAtual.getFavoritos();
        favoritos.add(atividade);
        usuarioAtual.setFavoritos(favoritos);
        usuarioRepository.save(usuarioAtual);
        
        return "Sucesso";
    }
}
