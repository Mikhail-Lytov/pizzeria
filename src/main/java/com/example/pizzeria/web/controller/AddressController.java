package com.example.pizzeria.web.controller;

import com.example.pizzeria.model.AddressEntity;
import com.example.pizzeria.service.AddressEntityService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class AddressController {
    private final AddressEntityService service;

    @GetMapping("/all")
    public ResponseEntity<List<AddressEntity>> getAll() {
        log.info("get all address");
        return ResponseEntity.ok(service.get());
    }

    @SneakyThrows
    @PostMapping("/new")
    public ResponseEntity<AddressEntity> newAddress(@RequestBody AddressEntity address) {
        log.info("new address");
        return ResponseEntity.ok(service.save(address));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAddress(@PathVariable Long id) {
        log.info("delete address");
        service.delete(id);
    }

    @PatchMapping("/update")
    public ResponseEntity<AddressEntity> updateAddress(@RequestBody AddressEntity address) {
        log.info("update address");

        return ResponseEntity.ok(service.update(address));
    }
}
