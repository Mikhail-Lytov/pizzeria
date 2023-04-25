package com.example.pizzeria.service;

import com.example.pizzeria.model.RolesEntity;
import com.example.pizzeria.repository.RolesEntityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleEntityServiceImpl implements RoleEntityService{
    private final RolesEntityRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<RolesEntity> get() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName()+" Error get list role: "+e.getMessage());
        }
    }

    @Override
    public RolesEntity update(RolesEntity roleUpdate) {
        try {
            RolesEntity old = repository.findById(roleUpdate.getId()).orElseThrow(RuntimeException::new);
            old = modelMapper.map(roleUpdate, RolesEntity.class);
            return repository.saveAndFlush(old);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName() + " Error update role: " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName() + " Error delete role: " + e.getMessage());
        }
    }

    @Override
    public RolesEntity save(RolesEntity role) {
        try {
            return repository.save(role);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName() + " Error save role: " + e.getMessage());
        }
    }

    @Override
    public RolesEntity getById(Long id) {
        try {
            return repository.findById(id).orElseThrow();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName()
                    + " Error get by id:"+ id.toString() + "role: "
                    + e.getMessage());
        }

    }
}
