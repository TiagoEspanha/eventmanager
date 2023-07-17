package com.tiagoespanha.eventmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiagoespanha.eventmanager.entities.Atividade;

public interface AtividadeRepository extends JpaRepository<Atividade, Long> {
    
}
