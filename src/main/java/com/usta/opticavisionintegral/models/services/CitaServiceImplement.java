package com.usta.opticavisionintegral.models.services;

import com.usta.opticavisionintegral.Entities.citaEntity;
import com.usta.opticavisionintegral.models.dao.citaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CitaServiceImplement implements IcitaService{
    @Autowired
    private citaDAO citaDAO;

    @Override
    @Transactional(readOnly = true)
    public List<citaEntity> findAll(){return (List<citaEntity>) citaDAO.findAll();}

    @Override
    @Transactional
    public void save(citaEntity cita){citaDAO.save(cita);}

    @Override
    @Transactional
    public void remove(Long id){citaDAO.deleteById(id);}

    @Override
    @Transactional
    public citaEntity updateCita(citaEntity cita){
        return citaDAO.save(cita);
    }

    @Override
    @Transactional
    public void changeState(Long id) {
        citaDAO.changeState(id);
    }

    @Override
    @Transactional(readOnly = true)
    public citaEntity findOne(Long id) {
        return citaDAO.findById(id).orElse(null);
    }
}