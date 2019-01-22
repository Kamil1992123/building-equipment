package pl.app.building.equipment.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@Entity
@Table(name = "device")
public class Device {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private int amount;
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToMany
    @JoinTable(name = "device_customers",
            joinColumns = {@JoinColumn(name = "device_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "customer_id", referencedColumnName = "id")}
    )
    private List<Customer> customers = new ArrayList<>();





}
