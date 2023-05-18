package com.usta.opticavisionintegral.models.dao;

import com.usta.opticavisionintegral.entities.doctorEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface doctorDAO extends CrudRepository<doctorEntity, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE doctorEntity SET estado = false WHERE iddoctor = ?1")
    public void changeState(Long id);
}

