package com.nb.springbootmicroserviceproductos.Controller;

import com.nb.springbootmicroserviceproductos.Models.Entity.Producto;
import com.nb.springbootmicroserviceproductos.Models.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductoController {

    @Autowired
    private Environment environment;

    @Value("${server.port}") //obtiene valor de la propiedad
    private int port;

    @Autowired
    private IProductoService productoService;

    @GetMapping("/listar")
    public List<Producto> listar() {
        return productoService.findAll().stream().map(producto -> {
            //producto.setPort(Integer.parseInt(environment.getProperty("local.server.port"))); //Obtiene y establece el puerto
            producto.setPort(port);
            return producto;
        }).collect(Collectors.toList());
    }

    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable Long id) throws Exception {
        Producto producto = productoService.findById(id);
        //producto.setPort(Integer.parseInt(environment.getProperty("local.server.port"))); //Obtiene y establece el puerto
        producto.setPort(port);

        return producto;
    }

    @PostMapping("/crear")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto crear(@RequestBody Producto producto) {
        return productoService.save(producto);
    }

    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Producto editar(@RequestBody Producto producto, @PathVariable Long id) {
        Producto productoFromDb = productoService.findById(id);

        productoFromDb.setNombre(producto.getNombre());
        productoFromDb.setPrecio(producto.getPrecio());

        return productoService.save(productoFromDb);
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        productoService.deleteById(id);
    }
}
