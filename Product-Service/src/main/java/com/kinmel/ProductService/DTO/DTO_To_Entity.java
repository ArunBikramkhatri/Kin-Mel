package com.kinmel.ProductService.DTO;

import com.kinmel.ProductService.Entity.Product;
import com.kinmel.ProductService.Entity.ProductList;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DTO_To_Entity {


    ModelMapper modelMapper = new ModelMapper();

    public ProductDto Procudt_to_DTO(Product product){
        ProductDto productDto = new ProductDto(product.getP_name(), product.getP_brand(), product.getP_quantity(), product.getPrice(), product.getCategories());
        return productDto;
    }

    public Product DTO_to_product(ProductDto productDto){
        Product product = new Product(productDto.getP_name(),productDto.getP_brand() ,productDto.getP_quantity(), productDto.getPrice(), productDto.getCategories());
        return product;
    }


    public ProductListDto List_To_DTO(List<Product> products){
        List<ProductDto> dtos = products
                .stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
        ProductListDto productListDto = new ProductListDto(dtos);
        return productListDto;
    }


}
