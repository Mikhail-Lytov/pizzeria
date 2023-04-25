package com.example.pizzeria.web.controller;

import com.example.pizzeria.model.RolesEntity;
import com.example.pizzeria.service.RoleEntityService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class RoleEntityController {
    private final RoleEntityService service;

    @GetMapping("/all")
    public ResponseEntity<List<RolesEntity>> getAll() {
        log.info("get all role");
        return ResponseEntity.ok(service.get());
    }

    @SneakyThrows
    @PostMapping("/new")
    public ResponseEntity<RolesEntity> newRole(@RequestBody RolesEntity Role) {
        log.info("new role");
        return ResponseEntity.ok(service.save(Role));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRole(@PathVariable Long id) {
        log.info("delete role");
        service.delete(id);
    }

    @PatchMapping("/update")
    public ResponseEntity<RolesEntity> updateRole(@RequestBody RolesEntity Role) {
        log.info("update role");

        return ResponseEntity.ok(service.update(Role));
    }
}
