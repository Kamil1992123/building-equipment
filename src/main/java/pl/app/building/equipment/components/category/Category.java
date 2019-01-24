package pl.app.building.equipment.components.category;

import lombok.*;
import pl.app.building.equipment.components.device.Device;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;



@Getter
@Setter
@Entity
@Table(name = "category")
@NoArgsConstructor
public class Category {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "category")
    private Set<Device> deviceSet = new HashSet<>();

}