package com.usta.opticavisionintegral.models.dao;

import com.usta.opticavisionintegral.entities.ciudadEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ciudadDAO extends CrudRepository<ciudadEntity, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE ciudadEntity SET estado = false WHERE id_ciudad = ?1")
    public void changeState(Long id);
}
