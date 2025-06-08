package com.example.backendCloud.controllers;
import java.util.Map;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class DefaultController {

    @PostMapping("/mensaje")
    public Map<String, String> mensaje() {
        System.out.println("Backend llamado");
        return Map.of("mensaje", "Integración OK al backend");
    }


    public static class MensajeRequest {
        private String key;
        public String getKey() { return key; }
        public void setKey(String key) { this.key = key; }
    }
}
