package com.api.assistech.assistech.controllers;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

import com.api.assistech.assistech.assembler.AgendamentoAssembler;
import com.api.assistech.assistech.entities.AssistenciaEntity;
import com.api.assistech.assistech.entities.ClienteEntity;
import com.api.assistech.assistech.model.AgendamentoModel;
import com.api.assistech.assistech.model.input.AgendamentoInput;
import com.api.assistech.assistech.repositories.ClienteRepository;
import com.api.assistech.assistech.service.RegistroAgendamentoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.assistech.assistech.entities.AgendamentoEntity;
import com.api.assistech.assistech.exception.ExceptionService;
import com.api.assistech.assistech.repositories.AgendamentoRepository;
import com.api.assistech.assistech.repositories.AssistenciaRepository;

import static java.time.temporal.ChronoUnit.DAYS;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/agendamentos")
public class AgendamentoController {

    private final AgendamentoRepository agendamentoRepository;
    private final RegistroAgendamentoService registroAgendamentoService;
    private final AgendamentoAssembler agendamentoAssembler;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AgendamentoModel incluir(@Valid @RequestBody AgendamentoInput agendamentoInput ){

        AgendamentoEntity agendamentoInserido = agendamentoAssembler.toEntity(agendamentoInput);
        AgendamentoEntity agendamentoCadastrado = registroAgendamentoService.salvar(agendamentoInserido);
        return agendamentoAssembler.toModel(agendamentoCadastrado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoModel> buscar(@PathVariable Long id) {

        return agendamentoRepository.findById(id)
                .map(agendamentoAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
    	registroAgendamentoService.excluir(id);

    }

    @GetMapping("/listarDatas")
    public List<AgendamentoModel> listarPorData(@RequestParam LocalDate data) {

        return agendamentoAssembler.toCollection(agendamentoRepository
                .findByHorarioBetween(data.atTime(00,00),data.atTime(23, 59)));
    }


    @GetMapping("/listar")
    public List<AgendamentoModel> listar() {
        return agendamentoAssembler.toCollection(agendamentoRepository.findAll());
    }

    @GetMapping("/listarhorarios/{assistenciaId}")
    public List<LocalTime> listarHorariosLivres(@PathVariable Long assistenciaId,
                                                @RequestParam LocalDate d) {

        return registroAgendamentoService.listarHorariosLivres(assistenciaId, d);
    }

    @GetMapping("/clientes/{cpf}")
    public List<AgendamentoModel> listarPorClientes(@PathVariable String cpf) {
        return agendamentoAssembler.toCollection(agendamentoRepository.findByClienteCpf(cpf));
    }


}