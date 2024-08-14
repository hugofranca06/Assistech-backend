package com.api.assistech.assistech.controllers;

import com.api.assistech.assistech.assembler.AssistenciaAssembler;
import com.api.assistech.assistech.entities.AssistenciaEntity;
import com.api.assistech.assistech.model.AssistenciaModel;
import com.api.assistech.assistech.model.input.AssistenciaInput;
import com.api.assistech.assistech.repositories.AssistenciaRepository;
import com.api.assistech.assistech.service.RegistroAssistenciaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@AllArgsConstructor
@RequestMapping("/assistencias")
public class AssistenciaController {

    private final AssistenciaRepository assistenciaRepository;
    private final AssistenciaAssembler assistenciaAssembler;
    private final RegistroAssistenciaService registroAssistenciaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AssistenciaModel assistenciaCadastro(@Valid @RequestBody AssistenciaInput assistenciaInput){
        AssistenciaEntity assistenciaInserida = assistenciaAssembler.toEntity(assistenciaInput);
        AssistenciaEntity assistenciaCadastrada = registroAssistenciaService.salvar(assistenciaInserida);
        return assistenciaAssembler.toModel(assistenciaCadastrada);
    }


    @GetMapping("/listar")
    public List<AssistenciaModel> listar() {
        return assistenciaAssembler.toCollection(assistenciaRepository.findAll());
    }
}


