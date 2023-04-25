package com.example.pizzeria.web.controller;

import com.example.pizzeria.model.IngreEntity;
import com.example.pizzeria.service.IngreEntityService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ingre")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class IngreEntityController {
    private final IngreEntityService service;

    @GetMapping("/all")
    public ResponseEntity<List<IngreEntity>> getAll() {
        log.info("get all ingre");
        return ResponseEntity.ok(service.get());
    }

    @SneakyThrows
    @PostMapping("/new")
    public ResponseEntity<IngreEntity> newIngre(@RequestBody IngreEntity ingre) {
        log.info("new ingre");
        return ResponseEntity.ok(service.save(ingre));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteIngre(@PathVariable Long id) {
        log.info("delete ingre");
        service.delete(id);
    }

    @PatchMapping("/update")
    public ResponseEntity<IngreEntity> updateIngre(@RequestBody IngreEntity ingre) {
        log.info("update ingre");

        return ResponseEntity.ok(service.update(ingre));
    }
}
