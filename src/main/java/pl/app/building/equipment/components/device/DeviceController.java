package pl.app.building.equipment.components.device;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.app.building.equipment.components.category.Category;
import pl.app.building.equipment.components.category.CategoryRepository;

import java.util.Optional;
import java.util.Scanner;

@Service
public class DeviceController {


    private Scanner scanner;
    private DeviceRepository deviceRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public DeviceController(Scanner scanner, DeviceRepository deviceRepository,CategoryRepository categoryRepository) {
        this.scanner = scanner;
        this.deviceRepository = deviceRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public void createDevice(){
        try{
        Device device = readDevice();
        deviceRepository.save(device);

        System.out.println("Dodane urządzenie");
        System.out.println(device);
        }
        catch (CategoryNotFoundException e){
            System.err.println("Urządzenia nie dodano. "+ e.getMessage());
        }

    }


    public Device readDevice(){

        Device device = new Device();
        System.out.println("Podaj nazwę urządzenia:");
        device.setName(scanner.nextLine());
        System.out.println("Podaj opis urządzenia:");
        device.setDescription(scanner.nextLine());
        System.out.println("Podaj stan magazynowy:");
        device.setAmount(scanner.nextInt());
        System.out.println("Podaj cenę:");
        device.setPrice(scanner.nextInt());
        System.out.println("Podaj kategorię urządzenia(id):");

        int categoryId = scanner.nextInt();
        Optional<Category> category = categoryRepository.findById(categoryId);
        scanner.nextLine();


        category.ifPresentOrElse(device::setCategory, ()
                -> {
            throw new CategoryNotFoundException("Kategoria o podanym ID nie isnieje.");
        });
        return device;
    }

    public void deleteDevice(){


        System.out.println("Podaj Id urządzenia do usunięcia:");
        int deviceId = scanner.nextInt();
        Optional<Device> device = deviceRepository.findById(deviceId);
        device.ifPresentOrElse(deviceRepository::delete,() -> System.out.println("Podano nie właściwe id urządzenia."));

    }



}
