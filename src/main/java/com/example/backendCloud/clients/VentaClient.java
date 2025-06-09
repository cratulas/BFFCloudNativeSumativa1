package com.example.backendCloud.clients;

import com.example.backendCloud.models.Venta;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class VentaClient {

    @Value("${microservicios.venta-url}")
    private String ventaUrl;

    private final RestTemplate restTemplate;

    public VentaClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Venta> listarVentas() {
        ResponseEntity<Venta[]> response = restTemplate.getForEntity(ventaUrl, Venta[].class);
        return Arrays.asList(response.getBody());
    }

    public Venta registrarVenta(Venta venta) {
        HttpEntity<Venta> entity = new HttpEntity<>(venta);
        return restTemplate.postForObject(ventaUrl, entity, Venta.class);
    }
}
