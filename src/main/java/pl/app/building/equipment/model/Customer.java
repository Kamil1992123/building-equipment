package pl.app.building.equipment.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Data
@Entity
@Table(name = "customer")
@NoArgsConstructor
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private long pesel;
    private int documentNumber;

    @ManyToMany(mappedBy = "customers")
    private List<Device> rentDevices = new ArrayList<>();





}