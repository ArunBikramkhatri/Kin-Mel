package com.kinmel.ProductService.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String p_id;
    private String p_name;
    private String p_brand;
    private int p_quantity;
    private int price;

   private Categories categories;

    public Product(String p_name ,String p_brand, int p_quantity, int price, Categories categories) {
        this.p_name = p_name;
        this.p_brand = p_brand;
        this.p_quantity = p_quantity;
        this.price = price;
        this.categories = categories;
    }
}
