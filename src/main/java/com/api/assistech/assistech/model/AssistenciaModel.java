package com.api.assistech.assistech.model;



import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class AssistenciaModel {

    private Long Id;
    private String nome;
    private LocalTime inicioExpediente;
    private LocalTime fimExpediente;
}
