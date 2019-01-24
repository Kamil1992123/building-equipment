package pl.app.building.equipment.components.device;

import lombok.*;
import pl.app.building.equipment.components.category.Category;
import pl.app.building.equipment.components.customer.Customer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@Entity
@Table(name = "device")
@NoArgsConstructor
public class Device {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private int amount;
    private int price;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "device_customers",
            joinColumns = {@JoinColumn(name = "device_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "customer_id", referencedColumnName = "id")}
    )
    private List<Customer> customers = new ArrayList<>();


    public void addCustomer(Customer customer) {
        customers.add(customer);
        customer.getRentDevices().add(this);
    }

}
