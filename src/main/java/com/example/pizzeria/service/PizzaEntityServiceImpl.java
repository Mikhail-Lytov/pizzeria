package com.example.pizzeria.service;

import com.example.pizzeria.model.IngreEntity;
import com.example.pizzeria.model.PizzaEntity;
import com.example.pizzeria.repository.IngreEntityRepository;
import com.example.pizzeria.repository.OrdersEntityRepository;
import com.example.pizzeria.repository.PizzaEntityRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PizzaEntityServiceImpl implements PizzaEntityService {
    private final PizzaEntityRepository repository;
    private final IngreEntityRepository repositoryIngre;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<PizzaEntity> get() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName()+" Error get list pizza: "+e.getMessage());
        }
    }

    @Override
    public PizzaEntity update(PizzaEntity pizzaUpdate) {
        try {
            PizzaEntity old = repository.findById(pizzaUpdate.getId()).orElseThrow(RuntimeException::new);
            old = modelMapper.map(pizzaUpdate, PizzaEntity.class);
            return repository.saveAndFlush(old);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName() + " Error update pizza: " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName() + " Error delete pizza: " + e.getMessage());
        }
    }

    @Override
    public PizzaEntity save(PizzaEntity pizza) {
        try {
            return repository.save(pizza);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName() + " Error save pizza: " + e.getMessage());
        }
    }

    @Override
    public PizzaEntity getById(Long id) {
        try {
            return repository.findById(id).orElseThrow();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName()
                    + " Error get by id:"+ id.toString() + "pizza: "
                    + e.getMessage());
        }

    }

    @Override
    public List<IngreEntity> getIngredients(Long id) {
        try {
            PizzaEntity pizza = repository.findById(id).orElseThrow();
            return pizza.getIngres();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName()
                    + " Error get by id pizza: "
                    + e.getMessage());
        }
    }

    @Override
    public PizzaEntity addIngredient(Long id, IngreEntity ingredient) {
        try {
            PizzaEntity pizza = repository.findById(id).orElseThrow();
            pizza.getIngres().add(repositoryIngre.findById(ingredient.getId()).orElseThrow());
            return repository.save(pizza);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName()
                    + " Error get by id pizza: "
                    + e.getMessage());
        }
    }

    @Override
    public PizzaEntity deleteIngreToPizza(Long id, IngreEntity ingre) {
        try {
            PizzaEntity pizza = repository.findById(id).orElseThrow();
            if (pizza.getIngres().stream().anyMatch(ingreEntity -> ingre.getId() == ingreEntity.getId())) {
                pizza.getIngres().remove(repositoryIngre.findById(ingre.getId()).orElseThrow());
            }
            return repository.save(pizza);
        }catch (Exception e){
            e.printStackTrace();
            throw  new RuntimeException(e.getClass().getSimpleName() + "Error add pizza to order");
        }
    }


}
