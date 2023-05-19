package com.usta.opticavisionintegral.models.services;

import com.usta.opticavisionintegral.entities.citaEntity;
import com.usta.opticavisionintegral.entities.doctorEntity;
import com.usta.opticavisionintegral.models.dao.doctorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class DoctorServiceImplement implements IdoctorService{

    @Autowired
    private doctorDAO doctorDAO;

    @Override
    @Transactional(readOnly = true)
    public List<doctorEntity> findAll(){
        return (List<doctorEntity>) doctorDAO.findAll();
    }

    @Override
    @Transactional
    public void save(doctorEntity doctor){
        doctorDAO.save(doctor);
    }


    @Override
    @Transactional
    public void remove(Long id){
        doctorDAO.deleteById(id);
    }



    @Override
    @Transactional
    public doctorEntity updateDoctor(doctorEntity doctor){

        return doctorDAO.save(doctor);
    }

    @Override
    @Transactional
    public void changeState(Long id){
        doctorDAO.changeState(id);
    }

    @Override
    @Transactional(readOnly = true)
    public doctorEntity findOne(Long id){
        return doctorDAO.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<doctorEntity> selectOneDoc(){
        return doctorDAO.selectOneDoc();
    }


}

