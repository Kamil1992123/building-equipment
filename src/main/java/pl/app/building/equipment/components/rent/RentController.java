package pl.app.building.equipment.components.rent;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.app.building.equipment.components.customer.Customer;
import pl.app.building.equipment.components.customer.CustomerRepository;
import pl.app.building.equipment.components.device.Device;
import pl.app.building.equipment.components.device.DeviceRepository;

import java.util.Optional;
import java.util.Scanner;

@Service
public class RentController {


    private Scanner scanner;
    private CustomerRepository customerRepository;
    private DeviceRepository deviceRepository;



    public RentController(Scanner scanner, CustomerRepository customerRepository, DeviceRepository deviceRepository) {
        this.scanner = scanner;
        this.customerRepository = customerRepository;
        this.deviceRepository = deviceRepository;
    }



    @Transactional
    public void rentDeviceToCustomer() {
        try {
            rent();
        } catch(RentException e) {
            System.err.println(e.getMessage());
        }
    }



    public void rent(){

            System.out.println("Podaj id klienta:");
            int customerId = scanner.nextInt();

            System.out.println("Podaj id urządzenia:");
            int deviceId = scanner.nextInt();

            Optional<Customer> customer = customerRepository.findById(customerId);
            Optional<Device> device = deviceRepository.findById(deviceId);

            if (customer.isPresent())
                device.ifPresentOrElse(dev -> {
                    if (dev.getAmount() > dev.getCustomers().size())
                        dev.addCustomer(customer.get());
                    else
                        throw new RentException("Brak urządzeń o wskazanym ID");
                },() -> {
                    throw new RentException("Brak urządzenia o wskazanym ID");
                });
            else throw new RentException("Brak klienta o danym ID");
        }
    }



