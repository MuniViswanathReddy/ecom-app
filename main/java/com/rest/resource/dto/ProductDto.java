package com.rest.resource.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDto {
    private String name;
    private int price;
    private int discountPrice;
    private String description;
    private String sku;
    private int quantity;
    private String quantityType;
    private String category;
    private String imageUrl;
    private String keywords;
}
