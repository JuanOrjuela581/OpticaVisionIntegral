package com.usta.opticavisionintegral.models.services;

import com.usta.opticavisionintegral.Entities.citaEntity;

import java.util.List;

public interface IcitaService {

    public List<citaEntity> findAll();

    public void save(citaEntity cita);

    public void remove(Long id);

    public citaEntity updateCita(citaEntity cita);

    public void changeState(Long id);

    public citaEntity findOne(Long id);
}
