package com.kinmel.ProductService.DTO;

import com.kinmel.ProductService.Entity.Product;
import org.springframework.stereotype.Component;

@Component
public class DTO_To_Entity {

    public ProductDto Procudt_to_DTO(Product product){
        ProductDto productDto = new ProductDto(product.getP_name(), product.getP_brand(), product.getP_quantity(), product.getPrice(), product.getCategories());
        return productDto;
    }

    public Product DTO_to_product(ProductDto productDto){
        Product product = new Product(productDto.getP_name(),productDto.getP_brand() ,productDto.getP_quantity(), productDto.getPrice(), productDto.getCategories());
        return product;
    }



}
