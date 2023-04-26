package com.kinmel.ProductService.DTO;

import com.kinmel.ProductService.Entity.Categories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String p_name;
    private String p_brand;
    private int p_quantity;
    private int price;

    private Categories categories;
}
