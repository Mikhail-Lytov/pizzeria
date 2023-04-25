package com.example.pizzeria.service;

import com.example.pizzeria.model.OrdersEntity;
import com.example.pizzeria.repository.OrdersEntityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersEntityServiceImpl implements OrdersEntityService{
    private final OrdersEntityRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<OrdersEntity> get() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName()+" Error get list order: "+e.getMessage());
        }
    }

    @Override
    public OrdersEntity update(OrdersEntity orderUpdate) {
        try {
            OrdersEntity old = repository.findById(orderUpdate.getId()).orElseThrow(RuntimeException::new);
            old = modelMapper.map(orderUpdate, OrdersEntity.class);
            return repository.saveAndFlush(old);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName() + " Error update order: " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName() + " Error delete order: " + e.getMessage());
        }
    }

    @Override
    public OrdersEntity save(OrdersEntity order) {
        try {
            return repository.save(order);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName() + " Error save order: " + e.getMessage());
        }
    }

    @Override
    public OrdersEntity getById(Long id) {
        try {
            return repository.findById(id).orElseThrow();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName()
                    + " Error get by id:"+ id.toString() + "order: "
                    + e.getMessage());
        }

    }
}
