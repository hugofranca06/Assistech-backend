package com.api.assistech.assistech.repositories;

import com.api.assistech.assistech.entities.AssistenciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.assistech.assistech.entities.AgendamentoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<AgendamentoEntity, Long>{

    List<AgendamentoEntity> findByAssistenciaIdAndHorarioBetween(Long assistenciaId, LocalDateTime inicio, LocalDateTime fim);

    List<AgendamentoEntity> findByClienteCpf(String cpf);
    List<AgendamentoEntity> findByHorarioBetween(LocalDateTime inicio, LocalDateTime fim);
}


