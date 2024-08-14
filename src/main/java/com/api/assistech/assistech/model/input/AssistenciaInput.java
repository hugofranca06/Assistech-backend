package com.api.assistech.assistech.model.input;


import com.api.assistech.assistech.validation.ValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Setter
@Getter
public class AssistenciaInput {

    @NotNull(groups = ValidationGroups.AssistenciaId.class)
    @Id
    private Long Id;

    @NotBlank
    @Size(max = 60)
    private String nome;

    private LocalTime inicioExpediente;
    private LocalTime fimExpediente;
}
