package com.example.backendCloud.models;

import java.time.LocalDateTime;
import java.util.List;

public class Venta {
    private Long id;
    private LocalDateTime fecha;
    private List<DetalleVenta> detalles;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }

    public List<DetalleVenta> getDetalles() { return detalles; }
    public void setDetalles(List<DetalleVenta> detalles) { this.detalles = detalles; }
}
