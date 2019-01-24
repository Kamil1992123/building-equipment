package pl.app.building.equipment.components.device;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.app.building.equipment.components.category.Category;

@Repository
public interface DeviceRepository extends CrudRepository<Device,Integer> {

}
