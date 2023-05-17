package com.usta.opticavisionintegral.models.services;

import com.usta.opticavisionintegral.Entities.opticaEntity;

import java.util.List;

public interface IopticaServices {

    public List<opticaEntity> finAll();

    public void save(opticaEntity optica);

    public void remove(Long id);

    public opticaEntity updateOptica(opticaEntity optica);

    public void changeState(Long id);

    public opticaEntity findOne(Long id);

}
