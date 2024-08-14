package com.api.assistech.assistech.entities;

import java.util.ArrayList;
import java.util.List;

import com.api.assistech.assistech.validation.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Entity
@Getter
@Setter
public class ClienteEntity {




	@NotBlank
	@NotNull(groups = ValidationGroups.ClientId.class)
	@Size(max = 11, min = 11)
	@Id
	@CPF
	private String cpf;

	@NotBlank
	@Size(max = 100)
	@Column(nullable = false)
	private String nome;

	@JsonIgnore
	@OneToMany(mappedBy = "cliente")
	private List<AgendamentoEntity> agendamento = new ArrayList<>();



}
