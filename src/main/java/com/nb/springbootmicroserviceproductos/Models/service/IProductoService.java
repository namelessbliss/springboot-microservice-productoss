package com.nb.springbootmicroserviceproductos.Models.service;

import com.nb.springbootmicroserviceproductos.Models.Entity.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> findAll();
    public Producto findById(Long id);
}
