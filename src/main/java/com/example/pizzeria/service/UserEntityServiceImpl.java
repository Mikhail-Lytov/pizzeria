package com.example.pizzeria.service;

import com.example.pizzeria.model.UserEntity;
import com.example.pizzeria.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserEntityServiceImpl implements UserEntityService{

    private final UserEntityRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserEntity> get() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName()+" Error get list user: "+e.getMessage());
        }
    }

    @Override
    public UserEntity update(UserEntity userUpdate) {
        try {
            UserEntity old = repository.findById(userUpdate.getId()).orElseThrow(RuntimeException::new);
            old = modelMapper.map(userUpdate, UserEntity.class);
            return repository.saveAndFlush(old);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName() + " Error update user: " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName() + " Error delete user: " + e.getMessage());
        }
    }

    @Override
    public UserEntity save(UserEntity user) {
        try {
            return repository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName() + " Error save user: " + e.getMessage());
        }
    }

    @Override
    public UserEntity getById(Long id) {
        try {
            return repository.findById(id).orElseThrow();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName()
                    + " Error get by id:"+ id.toString() + "user: "
                    + e.getMessage());
        }

    }
}
