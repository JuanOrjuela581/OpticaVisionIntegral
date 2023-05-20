package com.usta.opticavisionintegral.models.services;

import com.usta.opticavisionintegral.Entities.productoEntity;
import com.usta.opticavisionintegral.models.dao.productoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ProductoServiceImplement implements IproductoService {

    @Autowired
    private productoDAO productoDAO;

    @Override
    @Transactional(readOnly = true)
    public List<productoEntity> findAll() {
        return (List<productoEntity>) productoDAO.findAll();
    }

    @Override
    @Transactional
    public void save(productoEntity producto) {
        productoDAO.save(producto);
    }

    @Override
    @Transactional
    public void remove(Long id) {
        productoDAO.deleteById(id);
    }

    @Override
    @Transactional
    public productoEntity updateProducto(productoEntity producto) {
        return productoDAO.save(producto);
    }

    @Override
    @Transactional
    public void changeState(Long id) {
        productoDAO.changeState(id);
    }

    @Override
    @Transactional(readOnly = true)
    public productoEntity findOne(Long id) {
        return productoDAO.findById(id).orElse(null);
    }
}




