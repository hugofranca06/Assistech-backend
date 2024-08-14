package com.api.assistech.assistech.assembler;

import com.api.assistech.assistech.entities.AssistenciaEntity;
import com.api.assistech.assistech.model.AssistenciaModel;
import com.api.assistech.assistech.model.input.AssistenciaInput;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AssistenciaAssembler {

    private final ModelMapper modelMapper;

    public AssistenciaModel toModel(AssistenciaEntity assistencia) {
        return modelMapper.map(assistencia, AssistenciaModel.class);
    }

    public List<AssistenciaModel> toCollection(List<AssistenciaEntity> assistencias) {
        return assistencias.stream()
                .map(this::toModel)
                .toList();
    }

    public AssistenciaEntity toEntity(AssistenciaInput assistenciaInput) {
        return modelMapper.map(assistenciaInput, AssistenciaEntity.class);
    }
}
