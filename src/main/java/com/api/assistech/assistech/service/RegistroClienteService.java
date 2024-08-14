package com.api.assistech.assistech.service;

import com.api.assistech.assistech.entities.ClienteEntity;
import com.api.assistech.assistech.exception.ExceptionService;
import com.api.assistech.assistech.repositories.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroClienteService {

    private final ClienteRepository clienteRepository;

    @Transactional
    public ClienteEntity salvar(ClienteEntity clienteEntity){

        if (clienteRepository.existsById(clienteEntity.getCpf())){
            throw  new ExceptionService("Já existe um cliente cadastrado com esse CPF...");
        }

        return clienteRepository.save(clienteEntity);
    }

    public ClienteEntity buscar(String clienteId) {
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new ExceptionService("Cliente não encontrado"));
    }

}
