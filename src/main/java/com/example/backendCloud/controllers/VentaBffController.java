package com.example.backendCloud.controllers;

import com.example.backendCloud.clients.VentaClient;
import com.example.backendCloud.models.Venta;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bff/ventas")
@CrossOrigin
public class VentaBffController {

    private final VentaClient ventaClient;

    public VentaBffController(VentaClient ventaClient) {
        this.ventaClient = ventaClient;
    }

    @GetMapping
    public List<Venta> listar() {
        return ventaClient.listarVentas();
    }

    @PostMapping
    public Venta registrar(@RequestBody Venta venta) {
        return ventaClient.registrarVenta(venta);
    }
}
