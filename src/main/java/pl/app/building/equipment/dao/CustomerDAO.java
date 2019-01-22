package pl.app.building.equipment.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.app.building.equipment.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CustomerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Customer create(Customer customer){

        entityManager.persist(customer);
        return customer;
    }

    @Transactional
    public Customer read(int id){

        Customer customer = entityManager.find(Customer.class, id);
        return customer;
    }

    @Transactional
    public Customer update(Customer customer){

        return entityManager.merge(customer);
    }

    @Transactional
    public void delete(int id){

        Customer customer = entityManager.find(Customer.class,id);
        entityManager.remove(customer);
    }
}
