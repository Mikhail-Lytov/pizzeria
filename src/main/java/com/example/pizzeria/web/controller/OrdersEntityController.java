package com.example.pizzeria.web.controller;

import com.example.pizzeria.model.OrdersEntity;
import com.example.pizzeria.service.OrdersEntityService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class OrdersEntityController {
    private final OrdersEntityService service;

    @GetMapping("/all")
    public ResponseEntity<List<OrdersEntity>> getAll() {
        log.info("get all user");
        return ResponseEntity.ok(service.get());
    }

    @SneakyThrows
    @PostMapping("/new")
    public ResponseEntity<OrdersEntity> newUser(@RequestBody OrdersEntity order) {
        log.info("new order");
        return ResponseEntity.ok(service.save(order));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        log.info("delete order");
        service.delete(id);
    }

    @PatchMapping("/update")
    public ResponseEntity<OrdersEntity> updateUser(@RequestBody OrdersEntity order) {
        log.info("update order");

        return ResponseEntity.ok(service.update(order));
    }
}
