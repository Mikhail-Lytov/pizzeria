package com.example.pizzeria.service;

import com.example.pizzeria.model.OrdersEntity;
import com.example.pizzeria.model.RolesEntity;
import com.example.pizzeria.model.UserEntity;
import com.example.pizzeria.repository.OrdersEntityRepository;
import com.example.pizzeria.repository.RolesEntityRepository;
import com.example.pizzeria.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserEntityServiceImpl implements UserEntityService{

    private final UserEntityRepository repositoryUser;
    private final OrdersEntityRepository repositoryOrder;
    private final RolesEntityRepository repositoryRole;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserEntity> get() {
        try {
            return repositoryUser.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName()+" Error get list user: "+e.getMessage());
        }
    }

    @Override
    public UserEntity update(UserEntity userUpdate) {
        try {
            UserEntity old = repositoryUser.findById(userUpdate.getId()).orElseThrow(RuntimeException::new);
            old = modelMapper.map(userUpdate, UserEntity.class);
            return repositoryUser.saveAndFlush(old);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName() + " Error update user: " + e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try {
            repositoryUser.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName() + " Error delete user: " + e.getMessage());
        }
    }

    @Override
    public UserEntity save(UserEntity user) {
        try {
            return repositoryUser.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName() + " Error save user: " + e.getMessage());
        }
    }

    @Override
    public UserEntity getById(Long id) {
        try {
            return repositoryUser.findById(id).orElseThrow();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getClass().getSimpleName()
                    + " Error get by id:"+ id.toString() + "user: "
                    + e.getMessage());
        }

    }

    @Override
    public UserEntity addOrder(Long id, OrdersEntity order) {
        try {
            UserEntity user = repositoryUser.findById(id).orElseThrow();
            user.getOrders().add(repositoryOrder.findById(order.getId()).orElseThrow());
            return repositoryUser.save(user);
        }catch (Exception e){
            throw new RuntimeException(e.getClass().getSimpleName() +
                    "Errir add order to user" +
                    e.getMessage()
            );
        }
    }

    @Override
    public UserEntity addRole(Long id, RolesEntity role) {
        try {
            UserEntity user = repositoryUser.findById(id).orElseThrow();
            user.getRoles().add(repositoryRole.findById(role.getId()).orElseThrow());
            return repositoryUser.save(user);
        }catch (Exception e){
            throw new RuntimeException(e.getClass().getSimpleName() +
                    "Errir add order to user" +
                    e.getMessage()
            );
        }
    }

    @Override
    public UserEntity deleteRoleToUser(Long id, RolesEntity role) {
        try {
            UserEntity user = repositoryUser.findById(id).orElseThrow();
            if(user.getRoles().stream().anyMatch(pizzaEntity -> pizzaEntity.getId() == role.getId())){
                user.getRoles().remove(repositoryRole.getById(role.getId()));
            }

            return repositoryUser.save(user);
        }catch (Exception e){
            e.printStackTrace();
            throw  new RuntimeException(e.getClass().getSimpleName() + "Error delete role from user  ");
        }
    }

    @Override
    public UserEntity deleteOrderToUser(Long id, OrdersEntity order) {
        try {
            UserEntity user = repositoryUser.findById(id).orElseThrow();
            if(user.getOrders().stream().anyMatch(pizzaEntity -> pizzaEntity.getId() == order.getId())){
                user.getOrders().remove(repositoryOrder.getById(order.getId()));
            }


            return repositoryUser.save(user);
        }catch (Exception e){
            e.printStackTrace();
            throw  new RuntimeException(e.getClass().getSimpleName() + "Error delete order from user");
        }
    }
}
