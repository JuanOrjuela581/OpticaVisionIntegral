package com.usta.opticavisionintegral.models.services;

<<<<<<< Updated upstream
import com.usta.opticavisionintegral.Entities.pacienteEntity;
=======
import com.usta.opticavisionintegral.entities.pacienteEntity;
>>>>>>> Stashed changes
import com.usta.opticavisionintegral.models.dao.pacienteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PacienteServiceImplement implements IpacienteService {

    @Autowired
    private pacienteDAO pacienteDAO;

    @Override
    @Transactional(readOnly = true)
    public List<pacienteEntity> finAll(){
        return (List<pacienteEntity>) pacienteDAO.findAll();
    }

    @Override
    @Transactional
    public void save(pacienteEntity paciente){
        pacienteDAO.save(paciente);
    }

    @Override
    @Transactional
    public void remove(Long id){
        pacienteDAO.deleteById(id);
    }

    @Override
    @Transactional
    public pacienteEntity updatePaciente(pacienteEntity paciente){
        return pacienteDAO.save(paciente);
    }

    @Override
    @Transactional
    public void changeState(Long id) {
        pacienteDAO.changeState(id);
    }

    @Override
    @Transactional(readOnly = true)
    public pacienteEntity findOne(Long id) {
        return pacienteDAO.findById(id).orElse(null);
    }

}
