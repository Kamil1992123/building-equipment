package pl.app.building.equipment.dao;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.app.building.equipment.model.Device;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class DeviceDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Device create(Device device){

        entityManager.persist(device);
        return device;
    }

    @Transactional
    public Device read(int id){

       Device device = entityManager.find(Device.class,id);
       return device;
    }

    @Transactional
    public Device update(Device device){

        return entityManager.merge(device);

    }

    @Transactional
    public void delete(int id){

        Device device = entityManager.find(Device.class,id);
        entityManager.remove(device);
    }

}
