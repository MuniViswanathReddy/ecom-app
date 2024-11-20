package com.rest.resource.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "catalogy")
public class CatalogyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "catalogy_id")
    private int id;
    @Column(name = "catalogy")
    private String name;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "catalogyEntity", cascade = CascadeType.ALL)
    List<ProductEntity> productEntityList;
}
