package com.tiagoespanha.eventmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiagoespanha.eventmanager.entities.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    
}
