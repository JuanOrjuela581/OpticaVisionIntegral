package com.usta.opticavisionintegral.models.services;

<<<<<<< Updated upstream
import com.usta.opticavisionintegral.Entities.pacienteEntity;
=======
import com.usta.opticavisionintegral.entities.pacienteEntity;
>>>>>>> Stashed changes

import java.util.List;

public interface IpacienteService {

    public List<pacienteEntity> finAll();

    public void save(pacienteEntity paciente);

    public void remove(Long id);

    public pacienteEntity updatePaciente(pacienteEntity paciente);

    public void changeState(Long id);

    public pacienteEntity findOne(Long id);
}
