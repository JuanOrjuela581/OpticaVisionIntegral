package com.usta.opticavisionintegral.models.services;

<<<<<<< Updated upstream
import com.usta.opticavisionintegral.Entities.opticaEntity;
=======
import com.usta.opticavisionintegral.entities.opticaEntity;
>>>>>>> Stashed changes

import java.util.List;

public interface IopticaService {

    public List<opticaEntity> finAll();

    public void save(opticaEntity optica);

    public void remove(Long id);

    public opticaEntity updateOptica(opticaEntity optica);

    public void changeState(Long id);

    public opticaEntity findOne(Long id);

}
