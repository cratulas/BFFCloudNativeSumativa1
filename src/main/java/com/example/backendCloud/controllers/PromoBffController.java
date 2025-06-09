package com.example.backendCloud.controllers;

import com.example.backendCloud.clients.PromoClient;
import com.example.backendCloud.models.Promocion;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bff/promos")
@CrossOrigin
public class PromoBffController {

    private final PromoClient promoClient;

    public PromoBffController(PromoClient promoClient) {
        this.promoClient = promoClient;
    }

    @GetMapping
    public List<Promocion> listar() {
        return promoClient.listarPromos();
    }

    @GetMapping("/{id}")
    public Promocion obtener(@PathVariable Long id) {
        return promoClient.obtenerPorId(id);
    }

    @GetMapping("/producto/{productoId}")
    public List<Promocion> porProducto(@PathVariable Long productoId) {
        return promoClient.obtenerPorProducto(productoId);
    }

    @PostMapping
    public Promocion crear(@RequestBody Promocion promo) {
        return promoClient.crearPromo(promo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        promoClient.eliminarPromo(id);
    }
}
