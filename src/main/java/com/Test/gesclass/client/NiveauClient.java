package com.Test.gesclass.client;

import com.Test.gesclass.exception.ApiException;
import com.Test.gesclass.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class NiveauClient {
    private final RestTemplate restTemplate;

    @Value("${clients.niveau-url}")
    private String niveauServiceUrl;

    public NiveauClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean existsById(Long id) {
        try {
            Boolean exists = restTemplate.getForObject(niveauServiceUrl + "/" + id + "/exists", Boolean.class);
            if (exists == null) {
                throw new NotFoundException("Niveau avec id [" + id + "] inexistant!");
            }
            return exists;
        } catch (RestClientException e) {
            throw new ApiException("Erreur lors de la communication avec le service Niveau", 502);
        }
    }

    public String getLibelleById(Long id) {
        try {
            // Appel à l'endpoint GET /{id}/libelle du microservice niveau
            String url = niveauServiceUrl + "/" + id + "/libelle";
            String libelle = restTemplate.getForObject(url, String.class);
            if (libelle == null) {
                throw new NotFoundException("Niveau avec id [" + id + "] inexistant!");
            }
            return libelle;
        } catch (RestClientException e) {
            throw new ApiException("Erreur lors de la communication avec le service Niveau", 502);
        }
    }
} 