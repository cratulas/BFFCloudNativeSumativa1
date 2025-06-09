package com.example.backendCloud.models;

public class Promocion {
    private Long id;
    private Long productoId;
    private String descripcion;
    private Double descuento;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getProductoId() { return productoId; }
    public void setProductoId(Long productoId) { this.productoId = productoId; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Double getDescuento() { return descuento; }
    public void setDescuento(Double descuento) { this.descuento = descuento; }
}
