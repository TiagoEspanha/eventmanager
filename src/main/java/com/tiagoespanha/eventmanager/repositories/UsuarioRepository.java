package com.tiagoespanha.eventmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tiagoespanha.eventmanager.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
