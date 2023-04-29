package com.usta.opticavisionintegral.models.services;

import com.usta.opticavisionintegral.entities.proveedorEntity;

import java.util.List;

public interface IproveedorService {

    public List<proveedorEntity> findAll();

    public void save(proveedorEntity equipo);

    public void remove(Long id);

    public proveedorEntity updateEquipo(proveedorEntity equipo);

    public void changeState(Long id);

    public proveedorEntity findOne(Long id);
}
