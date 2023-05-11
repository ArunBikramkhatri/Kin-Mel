package com.kinmel.ProductService.Controller;

import com.kinmel.ProductService.DTO.ProductDto;
import com.kinmel.ProductService.DTO.ProductListDto;
import com.kinmel.ProductService.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kin-mel/product-service")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/register/productList")
    public ResponseEntity<String> registerProduct(@RequestBody ProductListDto productList){

        System.out.println(productList.getProductDtoList());
        List<ProductDto> products =productList.getProductDtoList();
        for (ProductDto productDto : products) {

            productService.saveProudct(productDto);
        }
        return ResponseEntity.ok("Product Registered");
    }

    @GetMapping("/product/{p_id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("p_id") String p_id){
        ProductDto productDto = productService.findProductById(p_id);
        return ResponseEntity.ok(productDto);
    }


    @GetMapping("/product/all")
    public ProductListDto getAllProduct(){
        ProductListDto productListDto = productService.findAllProduct();
        return productListDto;
    }


}
