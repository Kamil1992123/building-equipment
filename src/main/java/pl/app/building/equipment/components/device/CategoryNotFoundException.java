package pl.app.building.equipment.components.device;

public class CategoryNotFoundException extends RuntimeException {

    CategoryNotFoundException(String message){
        super (message);
    }
}
