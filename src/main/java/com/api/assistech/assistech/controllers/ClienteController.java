package com.api.assistech.assistech.controllers;

import com.api.assistech.assistech.assembler.ClienteAssembler;
import com.api.assistech.assistech.entities.ClienteEntity;
import com.api.assistech.assistech.model.ClienteModel;
import com.api.assistech.assistech.model.input.ClienteInput;
import com.api.assistech.assistech.repositories.ClienteRepository;
import com.api.assistech.assistech.service.RegistroClienteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteRepository clienteRepository;
    private final RegistroClienteService registroClienteService;
    private final ClienteAssembler clienteAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteModel cadastrarCliente(@Valid @RequestBody ClienteInput clienteInput){

        ClienteEntity clienteInserido = clienteAssembler.toEntity(clienteInput);
        ClienteEntity clienteCadastrado = registroClienteService.salvar(clienteInserido);
        return clienteAssembler.toModel(clienteCadastrado);
    }

    @GetMapping("/listar")
    public List<ClienteModel> listar() {
        return clienteAssembler.toCollection(clienteRepository.findAll());
    }


}
