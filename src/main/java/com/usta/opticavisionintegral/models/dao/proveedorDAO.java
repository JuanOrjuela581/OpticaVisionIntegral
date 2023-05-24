package com.usta.opticavisionintegral.models.dao;

import com.usta.opticavisionintegral.Entities.proveedorEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface proveedorDAO extends  CrudRepository<proveedorEntity, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE proveedorEntity SET estado = false WHERE id_proveedor = ?1")
    public void changeState(Long id);
}
