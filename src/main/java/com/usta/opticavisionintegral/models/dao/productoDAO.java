package com.usta.opticavisionintegral.models.dao;

import com.usta.opticavisionintegral.Entities.productoEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface productoDAO extends  CrudRepository<productoEntity, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE productoEntity SET estado = false WHERE id_producto = ?1")
    public void changeState(Long id);
}

