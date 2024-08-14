package com.api.assistech.assistech.entities;

import java.time.LocalTime;
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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class AssistenciaEntity {

	public final static int DURACAO_DA_ASSISTENCIA = 30;


	@NotNull(groups = ValidationGroups.AssistenciaId.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@NotBlank
	@Size(max = 60)
	@Column(nullable = false)
	private String nome;

	@JsonIgnore
	@OneToMany(mappedBy = "assistencia")
	private List<AgendamentoEntity> agendamento = new ArrayList<>();

	//@NotBlank
	private LocalTime inicioExpediente;
	//@NotBlank
	private LocalTime fimExpediente;
	
}
