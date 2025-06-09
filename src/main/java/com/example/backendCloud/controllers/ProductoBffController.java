package com.example.backendCloud.controllers;

import com.example.backendCloud.clients.ProductoClient;
import com.example.backendCloud.models.Producto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bff/productos")
@CrossOrigin
public class ProductoBffController {

    private final ProductoClient productoClient;

    public ProductoBffController(ProductoClient productoClient) {
        this.productoClient = productoClient;
    }

    @GetMapping
    public List<Producto> listar() {
        return productoClient.listarProductos();
    }

    @GetMapping("/{id}")
    public Producto obtener(@PathVariable Long id) {
        return productoClient.obtenerProducto(id);
    }

        @PostMapping
    public Producto crear(@RequestBody Producto producto) {
        return productoClient.crearProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizar(@PathVariable Long id, @RequestBody Producto producto) {
        return productoClient.actualizarProducto(id, producto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        productoClient.eliminarProducto(id);
    }

    @PutMapping("/{id}/descontar/{cantidad}")
    public void descontarStock(@PathVariable Long id, @PathVariable int cantidad) {
        productoClient.descontarStock(id, cantidad);
    }

}
