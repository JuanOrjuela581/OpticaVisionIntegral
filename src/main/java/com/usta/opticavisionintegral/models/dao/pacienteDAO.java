package com.usta.opticavisionintegral.models.dao;

import com.usta.opticavisionintegral.Entities.pacienteEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface pacienteDAO extends CrudRepository<pacienteEntity, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE pacienteEntity SET estado = false WHERE id_optica = ?1")
    public void changeState(Long id);

}
