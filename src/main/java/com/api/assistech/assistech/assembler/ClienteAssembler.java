package com.api.assistech.assistech.assembler;

import com.api.assistech.assistech.entities.ClienteEntity;
import com.api.assistech.assistech.model.ClienteModel;
import com.api.assistech.assistech.model.input.ClienteInput;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class ClienteAssembler {

    private final ModelMapper modelMapper;

    public ClienteModel toModel(ClienteEntity cliente) {
        return modelMapper.map(cliente, ClienteModel.class);
    }

    public List<ClienteModel> toCollection(List<ClienteEntity> clientes) {
        return clientes.stream()
                .map(this::toModel)
                .toList();
    }

    public ClienteEntity toEntity(ClienteInput clienteInput) {
        return modelMapper.map(clienteInput, ClienteEntity.class);
    }
}
