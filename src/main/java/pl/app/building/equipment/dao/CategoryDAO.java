package pl.app.building.equipment.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.app.building.equipment.model.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class CategoryDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Category create(Category category){

        entityManager.persist(category);
        return category;
    }

    @Transactional
    public Category read(int id){

        Category category = entityManager.find(Category.class,id);
        return category;
    }

    @Transactional
    public Category update(Category category){

       return entityManager.merge(category);
    }

    @Transactional
    public void delete(int id){

        Category category = entityManager.find(Category.class,id);
        entityManager.remove(category);
    }
}
