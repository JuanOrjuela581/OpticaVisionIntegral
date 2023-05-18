package com.usta.opticavisionintegral.models.services;

import com.usta.opticavisionintegral.entities.pacienteEntity;

import java.util.List;

public interface IpacienteService {

    public List<pacienteEntity> finAll();

    public void save(pacienteEntity paciente);

    public void remove(Long id);

    public pacienteEntity updatePaciente(pacienteEntity paciente);

    public void changeState(Long id);

    public pacienteEntity findOne(Long id);
}
