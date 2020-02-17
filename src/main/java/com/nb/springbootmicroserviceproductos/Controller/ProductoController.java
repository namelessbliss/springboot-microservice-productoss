package com.nb.springbootmicroserviceproductos.Controller;

import com.nb.springbootmicroserviceproductos.Models.Entity.Producto;
import com.nb.springbootmicroserviceproductos.Models.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductoController {

    @Autowired
    private Environment environment;

    @Autowired
    private IProductoService productoService;

    @GetMapping("/listar")
    public List<Producto> listar() {
        return productoService.findAll().stream().map(producto -> {
            producto.setPort(Integer.parseInt(environment.getProperty("local.server.port"))); //Obtiene y establece el puerto
            return producto;
        }).collect(Collectors.toList());
    }

    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable Long id) {
        Producto producto = productoService.findById(id);
        producto.setPort(Integer.parseInt(environment.getProperty("local.server.port"))); //Obtiene y establece el puerto
        return producto;
    }
}
