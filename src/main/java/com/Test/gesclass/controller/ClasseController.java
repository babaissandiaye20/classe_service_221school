package com.Test.gesclass.controller;

import com.Test.gesclass.dto.ClasseRequest;
import com.Test.gesclass.dto.ClasseResponse;
import com.Test.gesclass.helper.ClasseHelper;
import com.Test.gesclass.response.RequestResponse;
import com.Test.gesclass.response.ResponseResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClasseController {
    private final ClasseHelper classeHelper;

    public ClasseController(ClasseHelper classeHelper) {
        this.classeHelper = classeHelper;
    }

    @PostMapping
    public ResponseEntity<RequestResponse<ClasseResponse>> createClasse(@Valid @RequestBody ClasseRequest request) {
        ClasseResponse response = classeHelper.save(request);
        return ResponseEntity.status(201).body(
            RequestResponse.<ClasseResponse>builder()
                .data(response)
                .message("Classe créée avec succès")
                .build()
        );
    }

    @GetMapping
    public ResponseEntity<ResponseResponse<List<ClasseResponse>>> getAllClasses() {
        List<ClasseResponse> classes = classeHelper.findAll();
        return ResponseEntity.ok(
            ResponseResponse.<List<ClasseResponse>>builder()
                .data(classes)
                .message("Liste des classes")
                .build()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseResponse<ClasseResponse>> getClasseById(@PathVariable Long id) {
        ClasseResponse response = classeHelper.findById(id);
        return ResponseEntity.ok(
            ResponseResponse.<ClasseResponse>builder()
                .data(response)
                .message("Classe trouvée")
                .build()
        );
    }

    // Ajoute ici les endpoints pour update, delete, etc.
} 