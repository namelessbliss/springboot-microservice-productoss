package com.nb.springbootmicroserviceproductos.Models.service;

import com.nb.springbootmicroserviceproductos.Models.Entity.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> findAll();
    public Producto findById(Long id);

    public Producto save(Producto producto);

    public void deleteById(long id);
}
