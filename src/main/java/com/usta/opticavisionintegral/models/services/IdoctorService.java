package com.usta.opticavisionintegral.models.services;

import com.usta.opticavisionintegral.entities.doctorEntity;

import java.util.List;

public interface IdoctorService {

    public List<doctorEntity> findAll();

    public void save(doctorEntity doctor);

    public void remove(Long id);

    public doctorEntity updateDoctor(doctorEntity doctor);

    public void changeState(Long id);

    public doctorEntity findOne(Long id);
}


