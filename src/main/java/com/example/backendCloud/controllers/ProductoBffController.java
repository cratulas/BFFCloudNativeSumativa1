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
}
