package com.kinmel.ProductService.Service;

import com.kinmel.ProductService.DTO.DTO_To_Entity;
import com.kinmel.ProductService.DTO.ProductDto;
import com.kinmel.ProductService.Entity.Product;
import com.kinmel.ProductService.Repo.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
   private ProductRepo productRepo;

    @Autowired
    private DTO_To_Entity dtoToEntity;
   public void saveProudct(ProductDto productDto){
       Product product = dtoToEntity.DTO_to_product(productDto);
       productRepo.save(product);
       System.out.println("Product saved");
   }
    public void saveProudctList(List<Product> products){
        productRepo.saveAll(products);
        System.out.println("All Product saved");
    }

   public ProductDto findProductById(String id){

       Product product =  productRepo.findProductById(id);
       ProductDto productDto = dtoToEntity.Procudt_to_DTO(product);
       return productDto;
   }
}
