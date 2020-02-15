package com.nb.springbootmicroserviceproductos.Models.dao;

import com.nb.springbootmicroserviceproductos.Models.Entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoDao extends CrudRepository<Producto, Long> {
}
