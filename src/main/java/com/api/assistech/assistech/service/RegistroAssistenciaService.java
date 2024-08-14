package com.api.assistech.assistech.service;

import com.api.assistech.assistech.entities.AssistenciaEntity;
import com.api.assistech.assistech.exception.ExceptionService;
import com.api.assistech.assistech.repositories.AssistenciaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RegistroAssistenciaService {

    private final AssistenciaRepository assistenciaRepository;

    public AssistenciaEntity buscar(Long assistenciaId) {
        return assistenciaRepository
                .findById(assistenciaId)
                .orElseThrow(() -> new ExceptionService("Não existe assistencia para esse Id. "));
    }

    public AssistenciaEntity salvar(AssistenciaEntity assistencia) {

        if(assistencia.getInicioExpediente() == null || assistencia.getFimExpediente() == null){
            throw new ExceptionService("Horário inválido.");
        }

        if(assistencia.getFimExpediente().isBefore(assistencia.getInicioExpediente())){
            throw new ExceptionService("Horário do início do expediente precisa ser anterior ao do fim.");
        }

        return assistenciaRepository.save(assistencia);
    }
}
