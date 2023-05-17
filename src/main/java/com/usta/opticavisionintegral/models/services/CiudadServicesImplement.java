package com.usta.opticavisionintegral.models.services;

import com.usta.opticavisionintegral.Entities.ciudadEntity;
import com.usta.opticavisionintegral.models.dao.ciudadDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CiudadServicesImplement implements IciudadService {

    @Autowired
    private  ciudadDAO ciudadDAO;

    @Override
    @Transactional(readOnly = true)
    public List<ciudadEntity> finAll(){
        return (List<ciudadEntity>) ciudadDAO.findAll();
    }

    @Override
    @Transactional
    public void save(ciudadEntity ciudad){ciudadDAO.save(ciudad);}

    @Override
    @Transactional
    public void remove(Long id){
         ciudadDAO.deleteById(id);
    }

    @Override
    @Transactional
    public ciudadEntity updateCiudad(ciudadEntity ciudad){
        return ciudadDAO.save(ciudad);
    }

    @Override
    @Transactional
    public void changeState(Long id) {
        ciudadDAO.changeState(id);
    }

    @Override
    @Transactional(readOnly = true)
    public ciudadEntity findOne(Long id) {
        return ciudadDAO.findById(id).orElse(null);
    }

}
