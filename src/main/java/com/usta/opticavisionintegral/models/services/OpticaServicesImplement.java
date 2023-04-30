package com.usta.opticavisionintegral.models.services;

import com.usta.opticavisionintegral.Entities.opticaEntity;
import com.usta.opticavisionintegral.model.dao.opticadao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OpticaServicesImplement implements IopticaServices {

    @Autowired
    private opticadao opticadao;

    @Override
    @Transactional(readOnly = true)
    public List<opticaEntity> finAll(){
        return (List<opticaEntity>) opticadao.findAll();
    }

    @Override
    @Transactional
    public void save(opticaEntity optica){
        opticadao.save(optica);
    }

    @Override
    @Transactional
    public void remove(Long id){
        opticadao.deleteById(id);
    }

    @Override
    @Transactional
    public opticaEntity updateOptica(opticaEntity optica){
        return opticadao.save(optica);
    }

    @Override
    @Transactional(readOnly = true)
    public opticaEntity findOne(Long id) {
        return opticadao.findById(id).orElse(null);
    }

}
