package com.api.assistech.assistech.model.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssistenciaIdInput {

    @NotNull
    private Long id;
}
