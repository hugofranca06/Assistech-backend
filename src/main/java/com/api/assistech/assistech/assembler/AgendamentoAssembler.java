package com.api.assistech.assistech.assembler;

import com.api.assistech.assistech.entities.AgendamentoEntity;
import com.api.assistech.assistech.model.AgendamentoModel;
import com.api.assistech.assistech.model.input.AgendamentoInput;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AgendamentoAssembler {

    private final ModelMapper modelMapper;

    public AgendamentoModel toModel(AgendamentoEntity agendamento) {
        return modelMapper.map(agendamento, AgendamentoModel.class);
    }

    public List<AgendamentoModel> toCollection(List<AgendamentoEntity> agendamentos) {
        return agendamentos.stream()
                .map(this::toModel)
                .toList();
    }

    public AgendamentoEntity toEntity(AgendamentoInput agendamentoInput) {
        return modelMapper.map(agendamentoInput, AgendamentoEntity.class);
    }
}
