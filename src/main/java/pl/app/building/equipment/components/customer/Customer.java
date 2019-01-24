package pl.app.building.equipment.components.customer;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.app.building.equipment.components.device.Device;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@Entity
@Table(name = "customer")
@NoArgsConstructor
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String pesel;
    private String documentNumber;

    @ManyToMany(mappedBy = "customers")
    private List<Device> rentDevices = new ArrayList<>();


}