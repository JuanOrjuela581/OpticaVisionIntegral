package com.usta.opticavisionintegral.models.services;

import com.usta.opticavisionintegral.Entities.opticaEntity;
import com.usta.opticavisionintegral.models.dao.opticaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OpticaServicesImplement implements IopticaServices {

    @Autowired
    private opticaDAO opticaDAO;

    @Override
    @Transactional(readOnly = true)
    public List<opticaEntity> finAll(){
        return (List<opticaEntity>) opticaDAO.findAll();
    }

    @Override
    @Transactional
    public void save(opticaEntity optica){
        opticaDAO.save(optica);
    }

    @Override
    @Transactional
    public void remove(Long id){
        opticaDAO.deleteById(id);
    }

    @Override
    @Transactional
    public opticaEntity updateOptica(opticaEntity optica){
        return opticaDAO.save(optica);
    }

    @Override
    @Transactional
    public void changeState(Long id) {
        opticaDAO.changeState(id);
    }

    @Override
    @Transactional(readOnly = true)
    public opticaEntity findOne(Long id) {
        return opticaDAO.findById(id).orElse(null);
    }

}
