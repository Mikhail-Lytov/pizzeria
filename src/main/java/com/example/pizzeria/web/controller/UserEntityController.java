package com.example.pizzeria.web.controller;

import com.example.pizzeria.model.AddressEntity;
import com.example.pizzeria.model.OrdersEntity;
import com.example.pizzeria.model.UserEntity;
import com.example.pizzeria.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class UserEntityController {
    private final UserEntityService service;

    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> getAll() {
        log.info("get all user");
        return ResponseEntity.ok(service.get());
    }

    @SneakyThrows
    @PostMapping("/new")
    public ResponseEntity<UserEntity> newUser(@RequestBody UserEntity user) {
        log.info("new user");
        return ResponseEntity.ok(service.save(user));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        log.info("delete user");
        service.delete(id);
    }

    @PatchMapping("/update")
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user) {
        log.info("update user");

        return ResponseEntity.ok(service.update(user));
    }
    @PatchMapping("/addOrder/{id}")
    public ResponseEntity<UserEntity> addOrder(@PathVariable Long id, @RequestBody OrdersEntity order){
        log.info("add order");

        return ResponseEntity.ok(service.addOrder(id, order));
    }


    @PatchMapping("/delete/order/{id}")
    public ResponseEntity<UserEntity> deleteOtherToUser(@PathVariable Long id, @RequestBody OrdersEntity order){
        log.info("delete order from user");

        return ResponseEntity.ok(service.deleteOrderToUser(id, order));
    }

    @PatchMapping("/add/address/{id}")
    public ResponseEntity<UserEntity> addAddressFromUser(@PathVariable Long id, @RequestBody AddressEntity address){
        log.info("add address from user");

        return ResponseEntity.ok(service.addAdress(id, address));
    }
}
