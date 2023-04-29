package com.usta.opticavisionintegral.models.services;

import com.usta.opticavisionintegral.entities.proveedorEntity;
import com.usta.opticavisionintegral.models.dao.proveedorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ProveedorServiceImplement implements IproveedorService {

    @Autowired
    private proveedorDAO proveedorDAO;

    @Override
    @Transactional(readOnly = true)
    public List<proveedorEntity> findAll(){
        return (List<proveedorEntity>) proveedorDAO.findAll();
    }

    @Override
    @Transactional
    public void save(proveedorEntity equipo){
        proveedorDAO.save(equipo);
    }


    @Override
    @Transactional
    public void remove(Long id){
        proveedorDAO.deleteById(id);
    }



    @Override
    @Transactional
    public proveedorEntity updateEquipo(proveedorEntity equipo){

        return proveedorDAO.save(equipo);
    }

    @Override
    @Transactional
    public void changeState(Long id){
        proveedorDAO.changeState(id);
    }

    @Override
    @Transactional(readOnly = true)
    public proveedorEntity findOne(Long id){
        return proveedorDAO.findById(id).orElse(null);
    }


}
