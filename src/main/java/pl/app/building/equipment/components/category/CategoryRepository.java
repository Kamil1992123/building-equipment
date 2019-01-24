package pl.app.building.equipment.components.category;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.app.building.equipment.components.category.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Integer> {

}
