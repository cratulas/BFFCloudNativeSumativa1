package com.example.backendCloud.clients;

import com.example.backendCloud.models.Promocion;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
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

    public List<Promocion> obtenerPromos() {
    ResponseEntity<Promocion[]> response = restTemplate.getForEntity(promoUrl, Promocion[].class);
    return Arrays.asList(response.getBody());
    }

public List<Promocion> listarPromos() {
    try {
        System.out.println(">> Solicitando promociones a: " + promoUrl);
        Promocion[] promos = restTemplate.getForObject(promoUrl, Promocion[].class);
        System.out.println(">> Respuesta recibida: " + Arrays.toString(promos));
        return Arrays.asList(promos);
    } catch (Exception e) {
        System.err.println(">> Error al obtener promociones: " + e.getMessage());
        throw e;
    }
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
