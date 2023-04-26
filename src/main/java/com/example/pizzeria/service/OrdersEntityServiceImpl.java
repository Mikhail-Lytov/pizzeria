package com.example.pizzeria.service;

import com.example.pizzeria.model.OrdersEntity;
import com.example.pizzeria.model.PizzaEntity;
import com.example.pizzeria.repository.OrdersEntityRepository;
import com.example.pizzeria.repository.PizzaEntityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersEntityServiceImpl implements OrdersEntityService{
    private final OrdersEntityRepository repositoryOrders;
    private final PizzaEntityRepository repositoryPizza;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<OrdersEntity> get() {
        try {
            return repositoryOrders.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName()+" Error get list order: "+e.getMessage());
        }
    }

    @Override
    public OrdersEntity update(OrdersEntity orderUpdate) {
        try {
            OrdersEntity old = repositoryOrders.findById(orderUpdate.getId()).orElseThrow(RuntimeException::new);
            old = modelMapper.map(orderUpdate, OrdersEntity.class);
            return repositoryOrders.saveAndFlush(old);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName() + " Error update order: " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try {
            repositoryOrders.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName() + " Error delete order: " + e.getMessage());
        }
    }

    @Override
    public OrdersEntity save(OrdersEntity order) {
        try {
            return repositoryOrders.save(order);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName() + " Error save order: " + e.getMessage());
        }
    }

    @Override
    public OrdersEntity getById(Long id) {
        try {
            return repositoryOrders.findById(id).orElseThrow();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName()
                    + " Error get by id:"+ id.toString() + "order: "
                    + e.getMessage());
        }

    }

    @Override
    public OrdersEntity addPizzaToOrder(Long id, PizzaEntity pizza) {
        try {
            OrdersEntity orders = repositoryOrders.findById(id).orElseThrow();
            orders.getPizzas().add(repositoryPizza.findById(pizza.getId()).orElseThrow());
            return repositoryOrders.save(orders);
        }catch (Exception e){
            e.printStackTrace();
            throw  new RuntimeException(e.getClass().getSimpleName() + "Error add pizza to order");
        }
    }

    @Override
    public OrdersEntity deletePizzaToOrder(Long id, PizzaEntity pizza) {
        try {
            OrdersEntity orders = repositoryOrders.findById(id).orElseThrow();
            if(orders.getPizzas().stream().anyMatch(pizzaEntity -> pizzaEntity.getId() == pizza.getId())){
                orders.getPizzas().remove(repositoryPizza.getById(pizza.getId()));
            }


            return repositoryOrders.save(orders);
        }catch (Exception e){
            e.printStackTrace();
            throw  new RuntimeException(e.getClass().getSimpleName() + "Error add pizza to order");
        }
    }
}
