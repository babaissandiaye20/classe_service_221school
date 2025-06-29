package com.Test.gesclass.client;

import com.Test.gesclass.exception.ApiException;
import com.Test.gesclass.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class FiliereClient {
    private final RestTemplate restTemplate;

    @Value("${clients.filiere-url}")
    private String filiereServiceUrl;

    public FiliereClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean existsById(Long id) {
        try {
            // Appel GET pour vérifier l'existence (ex: /api/filieres/{id}/exists)
            Boolean exists = restTemplate.getForObject(filiereServiceUrl + "/" + id + "/exists", Boolean.class);
            if (exists == null) {
                throw new NotFoundException("Filière avec id [" + id + "] inexistante!");
            }
            return exists;
        } catch (RestClientException e) {
            throw new ApiException("Erreur lors de la communication avec le service Filiere", 502);
        }
    }
} 