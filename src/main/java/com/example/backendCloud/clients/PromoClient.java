package com.example.backendCloud.clients;

import com.example.backendCloud.models.Promocion;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PromoClient {

    @Value("${microservicios.promo-url}")
    private String promoUrl;

    private final RestTemplate restTemplate;

    public PromoClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Promocion> listarPromos() {
        Promocion[] promos = restTemplate.getForObject(promoUrl, Promocion[].class);
        return Arrays.asList(promos);
    }

    public Promocion obtenerPorId(Long id) {
        return restTemplate.getForObject(promoUrl + "/" + id, Promocion.class);
    }

    public List<Promocion> obtenerPorProducto(Long productoId) {
        Promocion[] promos = restTemplate.getForObject(promoUrl + "/producto/" + productoId, Promocion[].class);
        return Arrays.asList(promos);
    }

    public Promocion crearPromo(Promocion promo) {
        return restTemplate.postForObject(promoUrl, promo, Promocion.class);
    }

    public void eliminarPromo(Long id) {
        restTemplate.delete(promoUrl + "/" + id);
    }
}
