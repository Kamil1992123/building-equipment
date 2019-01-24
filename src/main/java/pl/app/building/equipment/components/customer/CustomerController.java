package pl.app.building.equipment.components.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.app.building.equipment.components.category.Category;

import java.util.Optional;
import java.util.Scanner;

@Service
public class CustomerController {


    private Scanner scanner;
    private CustomerRepository customerRepository;


    @Autowired
    public CustomerController(Scanner scanner, CustomerRepository customerRepository) {
        this.scanner = scanner;
        this.customerRepository = customerRepository;
    }




    public void createCustomer(){

        Customer customer = readCustomer();
        customerRepository.save(customer);

        System.out.println("Dodano klienta:");
        System.out.println(customer);


    }


    public Customer readCustomer(){


        Customer customer = new Customer();
        System.out.println("Podaj imię klienta:");
        customer.setName(scanner.nextLine());
        System.out.println("Podaj nazwisko klienta:");
        customer.setSurname(scanner.nextLine());
        System.out.println("Podaj pesel klienta:");
        customer.setPesel(scanner.nextLine());
        System.out.println("Podaj nr. dowodu klienta:");
        customer.setDocumentNumber(scanner.nextLine());

        return customer;
    }

    public void removeCustomer(){
        System.out.println("Podaj ID klienta którego chcesz usunąć:");
        int customerId = scanner.nextInt();
        Optional<Customer> customer = customerRepository.findById(customerId);
        customer.ifPresentOrElse(customerRepository::delete,() -> System.out.println("Brak kategorii o wskazanym ID"));


    }


}
