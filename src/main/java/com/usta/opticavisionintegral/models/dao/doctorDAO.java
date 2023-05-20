package com.usta.opticavisionintegral.models.dao;

import com.usta.opticavisionintegral.Entities.citaEntity;
import com.usta.opticavisionintegral.Entities.doctorEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface doctorDAO extends CrudRepository<doctorEntity, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE doctorEntity SET estado = false WHERE id_doctor = ?1")
    public void changeState(Long id);

    @Transactional
    @Modifying
    @Query("SELECT doc FROM doctorEntity doc WHERE doc.id_doctor NOT IN (SELECT cit.id_doctor.id_doctor FROM citaEntity cit)")
    public List <doctorEntity> selectOneDoc();
}

