package org.example.productcatalogservice.dtos;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class CategoryDto {
    private int id;

    private String name;

    private String description;

    private CategoryDto category;
}