package org.example.productcatalogservice.services;

import org.example.productcatalogservice.models.Product;

import java.util.List;

public interface IProductService {
    public Product getProductById(int id);

    public  Product createProduct(Product product);

    public List<Product> getAllProducts();
}
