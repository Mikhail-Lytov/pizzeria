package com.example.pizzeria.service;

import com.example.pizzeria.model.AddressEntity;
import com.example.pizzeria.model.IngreEntity;
import com.example.pizzeria.repository.AddressEntityRepository;
import com.example.pizzeria.repository.IngreEntityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressEntityServiceImpl implements AddressEntityService{
    private final AddressEntityRepository repository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<AddressEntity> get() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName()+" Error get list address: "+e.getMessage());
        }
    }

    @Override
    public AddressEntity update(AddressEntity addressUpdate) {
        try {
            AddressEntity old = repository.findById(addressUpdate.getId()).orElseThrow(RuntimeException::new);
            old = modelMapper.map(addressUpdate, AddressEntity.class);
            return repository.saveAndFlush(old);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName() + " Error update address: " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName() + " Error delete address: " + e.getMessage());
        }
    }

    @Override
    public AddressEntity save(AddressEntity address) {
        try {
            return repository.save(address);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName() + " Error save address: " + e.getMessage());
        }
    }

    @Override
    public AddressEntity getById(Long id) {
        try {
            return repository.findById(id).orElseThrow();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName()
                    + " Error get by id address: "
                    + e.getMessage());
        }
    }
}
