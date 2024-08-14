package com.api.assistech.assistech.model.input;

import com.api.assistech.assistech.entities.AssistenciaEntity;
import com.api.assistech.assistech.entities.ClienteEntity;
import com.api.assistech.assistech.entities.TipoEquipamento;
import com.api.assistech.assistech.validation.ValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AgendamentoInput {

    @Valid
    @NotNull
    private ClienteIdInput cliente;

    @Valid
    @NotNull
    private AssistenciaIdInput assistencia;

    @FutureOrPresent
    private LocalDateTime horario;

    @Enumerated(EnumType.STRING)
    private TipoEquipamento equipamento;
}
