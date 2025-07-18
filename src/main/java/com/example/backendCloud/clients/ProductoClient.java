package com.example.backendCloud.clients;

import com.example.backendCloud.models.Producto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductoClient {

    @Value("${microservicios.producto-url}")
    private String productoUrl;

    private final RestTemplate restTemplate;

    public ProductoClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Producto> listarProductos() {
        Producto[] productos = restTemplate.getForObject(productoUrl, Producto[].class);
        return Arrays.asList(productos);
    }

    public Producto obtenerProducto(Long id) {
        return restTemplate.getForObject(productoUrl + "/" + id, Producto.class);
    }

    public Producto crearProducto(Producto producto) {
    return restTemplate.postForObject(productoUrl, producto, Producto.class);
    }

    public Producto actualizarProducto(Long id, Producto producto) {
        String url = productoUrl + "/" + id;
        restTemplate.put(url, producto);
        return obtenerProducto(id);
    }

    public void eliminarProducto(Long id) {
        restTemplate.delete(productoUrl + "/" + id);
    }

    public void descontarStock(Long id, int cantidad) {
        String url = productoUrl + "/" + id + "/descontar/" + cantidad;
        restTemplate.put(url, null);
    }

}
