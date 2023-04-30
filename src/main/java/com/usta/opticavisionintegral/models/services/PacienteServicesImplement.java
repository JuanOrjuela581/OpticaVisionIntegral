package com.usta.opticavisionintegral.models.services;

import com.usta.opticavisionintegral.Entities.pacienteEntity;
import com.usta.opticavisionintegral.model.dao.pacientedao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PacienteServicesImplement implements IpacienteServices{

    @Autowired
    private pacientedao pacientedao;

    @Override
    @Transactional(readOnly = true)
    public List<pacienteEntity> finAll(){
        return (List<pacienteEntity>) pacientedao.findAll();
    }

    @Override
    @Transactional
    public void save(pacienteEntity paciente){
        pacientedao.save(paciente);
    }

    @Override
    @Transactional
    public void remove(Long id){
        pacientedao.deleteById(id);
    }

    @Override
    @Transactional
    public pacienteEntity updatePaciente(pacienteEntity paciente){
        return pacientedao.save(paciente);
    }

    @Override
    @Transactional(readOnly = true)
    public pacienteEntity findOne(Long id) {
        return pacientedao.findById(id).orElse(null);
    }

}
