package com.tiagoespanha.eventmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiagoespanha.eventmanager.entities.Edicao;

public interface EdicaoRepository extends JpaRepository<Edicao, Long> {
    
}
