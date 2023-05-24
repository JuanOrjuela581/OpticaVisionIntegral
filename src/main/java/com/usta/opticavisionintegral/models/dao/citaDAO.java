package com.usta.opticavisionintegral.models.dao;

import com.usta.opticavisionintegral.Entities.citaEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface citaDAO extends CrudRepository<citaEntity, Long>{

    @Transactional
    @Modifying
    @Query("UPDATE citaEntity SET estado = false WHERE id_cita = ?1")
    public void changeState(Long id);
}
