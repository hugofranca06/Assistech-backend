package com.api.assistech.assistech.service;

import com.api.assistech.assistech.entities.AgendamentoEntity;
import com.api.assistech.assistech.entities.AssistenciaEntity;
import com.api.assistech.assistech.entities.ClienteEntity;
import com.api.assistech.assistech.exception.ExceptionService;
import com.api.assistech.assistech.repositories.AgendamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor

public class RegistroAgendamentoService {

        private final AgendamentoRepository agendamentoRepository;

        private final RegistroAssistenciaService registroAssistenciaService;

        private final RegistroClienteService registroClienteService;

        @Transactional
        public AgendamentoEntity salvar(AgendamentoEntity agendamento){

            AssistenciaEntity assistencia = registroAssistenciaService
                    .buscar(agendamento.getAssistencia().getId());

            ClienteEntity cliente = registroClienteService.buscar(agendamento.getCliente().getCpf());

            LocalTime horarioProposto = LocalTime.from(agendamento.getHorario());

            if(horarioProposto.isBefore(assistencia.getInicioExpediente())
                    || horarioProposto.isAfter(assistencia.getFimExpediente()))  {

                throw new ExceptionService("Estabelecimento fechado nesse horário.");
            }

            List<LocalTime> horarioLivres = listarHorariosLivres(agendamento.getAssistencia().getId(), agendamento.getHorario().toLocalDate());

            if(!horarioLivres.contains(agendamento.getHorario().toLocalTime())) {
                throw new ExceptionService("Horário indisponível");
            }
            agendamento.setAssistencia(assistencia);
            agendamento.setCliente(cliente);

            return agendamentoRepository.save(agendamento);
        }
        public AgendamentoEntity buscar(Long agendamentoId){

            return agendamentoRepository.findById(agendamentoId)
                    .orElseThrow(() -> new ExceptionService("Agendamento não encontrado"));
        }
        public void excluir(Long agendamentoId){

            agendamentoRepository.deleteById(agendamentoId);
        }

    public List<LocalTime> listarHorariosLivres(Long idAssistencia, LocalDate data) {

        AssistenciaEntity assistencia = registroAssistenciaService.buscar(idAssistencia);

        LocalTime horarioInicio = assistencia.getInicioExpediente();
        LocalTime horarioFim = assistencia.getFimExpediente();

        LocalDateTime horarioDataInicial = horarioInicio.atDate(data);
        LocalDateTime horaraioDataFinal = horarioFim.atDate(data);

        List<LocalTime> horariosPossiveis = new ArrayList<>();
        List<LocalTime> horariosMarcados = new ArrayList<>();

        while(horarioInicio.isBefore(horarioFim)) {
            horariosPossiveis.add(horarioInicio);
            horarioInicio = horarioInicio.plusMinutes(assistencia.DURACAO_DA_ASSISTENCIA);
        }

        List<AgendamentoEntity> agendamentos = agendamentoRepository
                .findByAssistenciaIdAndHorarioBetween(idAssistencia, horarioDataInicial,horaraioDataFinal);

        for(AgendamentoEntity agendamento : agendamentos) {
            LocalTime horaMarcada = agendamento.getHorario().toLocalTime();
            horariosMarcados.add(horaMarcada);
        }

        List<LocalTime> horariosDisponiveis = new ArrayList<>(horariosPossiveis);
        horariosDisponiveis.removeAll(horariosMarcados);

        return horariosDisponiveis;
    }

}
