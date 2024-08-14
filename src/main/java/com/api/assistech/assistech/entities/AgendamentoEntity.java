package com.api.assistech.assistech.entities;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.api.assistech.assistech.validation.ValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import lombok.Data;

@Data
@Entity
public class AgendamentoEntity {


	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAgendamento;

	@Valid
	@ConvertGroup(from = Default.class, to = ValidationGroups.ClientId.class)
	@NotNull
	@ManyToOne
	private ClienteEntity cliente;

	@Valid
	@ConvertGroup(from = Default.class, to = ValidationGroups.AssistenciaId.class)
	@NotNull
	@ManyToOne
	//@JoinColumn(name = "idAssistencia")
	private AssistenciaEntity assistencia;
	
	@FutureOrPresent
	private LocalDateTime horario;
	
	@Enumerated(EnumType.STRING)
	private TipoEquipamento equipamento;


}
