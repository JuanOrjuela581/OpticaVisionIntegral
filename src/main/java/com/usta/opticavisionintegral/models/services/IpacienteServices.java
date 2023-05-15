package com.usta.opticavisionintegral.models.services;

import com.usta.opticavisionintegral.Entities.pacienteEntity;

import java.util.List;

public interface IpacienteServices {

    public List<pacienteEntity> finAll();

    public void save(pacienteEntity paciente);

    public void remove(Long id);

    public pacienteEntity updatePaciente(pacienteEntity paciente);

    public void changeState(Long id);

    public pacienteEntity findOne(Long id);
}
