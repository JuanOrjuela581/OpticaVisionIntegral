package com.usta.opticavisionintegral.models.services;

import com.usta.opticavisionintegral.Entities.ciudadEntity;
import com.usta.opticavisionintegral.model.dao.ciudaddao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CiudadServicesImplement implements IciudadServices{

    @Autowired
    private ciudaddao ciudaddao;

    @Override
    @Transactional(readOnly = true)
    public List<ciudadEntity> finAll(){
        return (List<ciudadEntity>) ciudaddao.findAll();
    }

    @Override
    @Transactional
    public void save(ciudadEntity ciudad){ciudaddao.save(ciudad);}

    @Override
    @Transactional
    public void remove(Long id){
        ciudaddao.deleteById(id);
    }

    @Override
    @Transactional
    public ciudadEntity updateCiudad(ciudadEntity ciudad){
        return ciudaddao.save(ciudad);
    }

    @Override
    @Transactional(readOnly = true)
    public ciudadEntity findOne(Long id) {
        return ciudaddao.findById(id).orElse(null);
    }

}
