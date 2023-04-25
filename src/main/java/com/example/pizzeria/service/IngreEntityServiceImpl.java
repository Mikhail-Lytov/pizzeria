package com.example.pizzeria.service;

import com.example.pizzeria.model.IngreEntity;
import com.example.pizzeria.repository.IngreEntityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngreEntityServiceImpl implements IngreEntityService{

    private final IngreEntityRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<IngreEntity> get() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName()+" Error get list engrety: "+e.getMessage());
        }
    }

    @Override
    public IngreEntity update(IngreEntity engretyUpdate) {
        try {
            IngreEntity old = repository.findById(engretyUpdate.getId()).orElseThrow(RuntimeException::new);
            old = modelMapper.map(engretyUpdate, IngreEntity.class);
            return repository.saveAndFlush(old);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName() + " Error update engrety: " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName() + " Error delete engrety: " + e.getMessage());
        }
    }

    @Override
    public IngreEntity save(IngreEntity engrety) {
        try {
            return repository.save(engrety);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName() + " Error save engrety: " + e.getMessage());
        }
    }

    @Override
    public IngreEntity getById(Long id) {
        try {
            return repository.findById(id).orElseThrow();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName()
                    + " Error get by id:"+ id.toString() + "engrety: "
                    + e.getMessage());
        }

    }
}
