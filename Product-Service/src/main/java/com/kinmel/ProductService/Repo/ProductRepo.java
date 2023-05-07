package com.kinmel.ProductService.Repo;

import com.kinmel.ProductService.Entity.Product;
import com.kinmel.ProductService.Entity.ProductList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product , String> {

    @Query("select p from Product p where p.p_id =:p_id")
    public Product findProductById(@Param("p_id") String p_id);

    @Query("select p from Product p")
    public List<Product> findAllProducts();
}
