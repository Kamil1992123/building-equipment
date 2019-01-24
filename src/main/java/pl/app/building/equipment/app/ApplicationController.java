package pl.app.building.equipment.app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.app.building.equipment.components.category.CategoryController;
import pl.app.building.equipment.components.customer.CustomerController;
import pl.app.building.equipment.components.device.DeviceController;
import pl.app.building.equipment.components.rent.RentController;

import java.util.Arrays;
import java.util.Scanner;

@Controller
public class ApplicationController {



    private Scanner scanner;
    private DeviceController deviceController;
    private CategoryController categoryController;
    private CustomerController customerController;
    private RentController rentController;


    public ApplicationController(Scanner scanner, DeviceController deviceController, CategoryController categoryController, CustomerController customerController, RentController rentController) {
        this.scanner = scanner;
        this.deviceController = deviceController;
        this.categoryController = categoryController;
        this.customerController = customerController;
        this.rentController = rentController;
    }

   public void mainLoop(){
       Options option;
       do{
           printOptions();
           option = readOption();
           executeOption(option);
       }while (option != Options.EXIT);
   }



    private void printOptions() {
        System.out.println("Opcje:");
        Arrays.stream(Options.values()).forEach(System.out::println);
    }


    private Options readOption() {
        boolean correctOptionSelected = false;
        Options option = null;
        while(!correctOptionSelected) {
            System.out.println("Podaj ID opcji:");
            int optionId = scanner.nextInt();
            scanner.nextLine();
            try {
                option = Options.numberToCategory(optionId);
                correctOptionSelected = true;
            } catch(InvalidOptionException e) {
                System.err.println(e.getMessage());
            }
        }
        return option;
    }

    private void executeOption(Options option) {
        switch (option) {
            case ADD_DEVICE:
                deviceController.createDevice();
                break;
            case ADD_CATEGORY:
                categoryController.createCategory();
                break;
            case ADD_CUSTOMER:
                customerController.createCustomer();
                break;
            case RENT:
                rentController.rentDeviceToCustomer();
                break;
            case REMOVE_DEVICE:
                deviceController.deleteDevice();
                break;
            case REMOVE_CATEGORY:
                categoryController.removeCategory();
                break;
            case REMOVE_CUSTOMER:
                customerController.removeCustomer();
                break;
            case EXIT:
                closeApp();
        }
    }


    private void closeApp() {
        scanner.close();
        System.out.println("Bye bye!");
    }




}
