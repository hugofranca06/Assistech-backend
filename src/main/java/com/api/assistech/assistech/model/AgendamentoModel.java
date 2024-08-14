package com.api.assistech.assistech.model;

import com.api.assistech.assistech.entities.AssistenciaEntity;
import com.api.assistech.assistech.entities.ClienteEntity;
import com.api.assistech.assistech.entities.TipoEquipamento;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;

@Getter
@Setter
public class AgendamentoModel {

    private Long idAgendamento;
    private ClienteResumoModel cliente;
    private AssistenciaResumoModel assistencia;
    private LocalDateTime horario;
    private TipoEquipamento equipamento;

}
