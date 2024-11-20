package com.rest.resource.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CatalogyDto {
    private String name;
    private String description;
    private List<ProductDto> products;
}
