package com.rest.resource.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = " product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private int price;
    @Column(name = "discount_price")
    private int discountPrice;
    @Column(name = "description")
    private String description;
    @Column(name = "sku")
    private String sku;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "quantity_type")
    private String quantityType;
    @Column(name = "category")
    private String category;
    @Column(name = "image_url")
    private String image;
    @Column(name = "key_words")
    private String keywords;
    @ManyToOne
    @JoinColumn(name = "product_catalogy_id", nullable = true)
    private CatalogyEntity catalogyEntity;

}
