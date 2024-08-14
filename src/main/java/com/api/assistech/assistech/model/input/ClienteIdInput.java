package com.api.assistech.assistech.model.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteIdInput {

    @NotBlank
    private String cpf;

}
