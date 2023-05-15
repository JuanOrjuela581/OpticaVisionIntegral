package com.usta.opticavisionintegral.models.services;

import com.usta.opticavisionintegral.Entities.ciudadEntity;

import java.util.List;

public interface IciudadServices {
    public List<ciudadEntity> finAll();

    public void save(ciudadEntity ciudad);

    public void remove(Long id);

    public ciudadEntity updateCiudad(ciudadEntity ciudad);

    public void changeState(Long id);

    public ciudadEntity findOne(Long id);
}
