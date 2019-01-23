package pl.app.building.equipment.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
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