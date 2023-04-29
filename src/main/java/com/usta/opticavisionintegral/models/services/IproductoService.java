package com.usta.opticavisionintegral.models.services;

import com.usta.opticavisionintegral.entities.productoEntity;

import java.util.List;

public interface IproductoService {

    public List<productoEntity> findAll();

    public void save(productoEntity producto);

    public void remove(Long id);

    public productoEntity updateProducto(productoEntity producto);

    public void changeState(Long id);

    public productoEntity findOne(Long id);
}

