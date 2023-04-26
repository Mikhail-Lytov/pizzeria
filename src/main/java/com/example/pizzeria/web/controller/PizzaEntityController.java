package com.example.pizzeria.web.controller;

import com.example.pizzeria.model.IngreEntity;
import com.example.pizzeria.model.PizzaEntity;
import com.example.pizzeria.service.PizzaEntityService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pizza")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class PizzaEntityController {
    private final PizzaEntityService service;

    @GetMapping("/all")
    public ResponseEntity<List<PizzaEntity>> getAll() {
        log.info("get all pizza");
        return ResponseEntity.ok(service.get());
    }

    @SneakyThrows
    @PostMapping("/new")
    public ResponseEntity<PizzaEntity> newUser(@RequestBody PizzaEntity pizza) {
        log.info("new pizza");
        return ResponseEntity.ok(service.save(pizza));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
        log.info("delete pizza");
        service.delete(id);
    }

    @PatchMapping("/update")
    public ResponseEntity<PizzaEntity> updateUser(@RequestBody PizzaEntity pizza) {
        log.info("update pizza");

        return ResponseEntity.ok(service.update(pizza));
    }

    @PatchMapping("add/ingredient/{id}")
    public ResponseEntity<PizzaEntity> addIngredient(@PathVariable Long id, @RequestBody IngreEntity ingredient){
        return ResponseEntity.ok(service.addIngredient(id, ingredient));
    }

    @GetMapping("/ingredients/{id}")
    public ResponseEntity<List<IngreEntity>> getIngredients(@PathVariable Long id){
        return ResponseEntity.ok(service.getIngredients(id));
    }

    @PatchMapping("/delete/Ingredient/{id}")
    public  ResponseEntity<PizzaEntity> deleteIngreToPizza(@PathVariable Long id, @RequestBody IngreEntity ingre){
        return ResponseEntity.ok(service.deleteIngreToPizza(id, ingre));
    }
}
