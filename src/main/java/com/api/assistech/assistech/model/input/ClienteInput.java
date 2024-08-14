package com.api.assistech.assistech.model.input;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
public class ClienteInput {

    @NotBlank
    @Size(max = 11, min = 11)
    @Id
    @CPF
    private String cpf;

    @NotBlank
    @Size(max = 100, min = 2)
    @Pattern(regexp = "[a-zA-Z\\sáéíóúÁÉÍÓÚãõâêîôûÂÊÎÔÛçÇ]+",
            message = "O nome deve conter apenas letras, espaços e acentos permitidos")
    private String nome;
}
