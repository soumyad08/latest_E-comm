package org.example.productcatalogservice.dtos;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class ProductDto {
    private int id;

    private String name;

    private String description;

    private Double price;

    private CategoryDto category;

    private String imageURL;

    public ProductDto() {
    }
}
