package com.api.assistech.assistech.repositories;

import com.api.assistech.assistech.entities.AgendamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.assistech.assistech.entities.ClienteEntity;

import java.util.List;

public interface ClienteRepository extends JpaRepository<ClienteEntity, String>{



}
