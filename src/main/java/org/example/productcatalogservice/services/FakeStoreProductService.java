package org.example.productcatalogservice.services;
import org.example.productcatalogservice.dtos.FakeStoreProductDto;
import org.example.productcatalogservice.models.Category;
import org.example.productcatalogservice.models.Product;
import org.example.productcatalogservice.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements IProductService {

    @Autowired
    public RestTemplateBuilder restTemplateBuilder;

    @Override
    public Product getProductById(int id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductDto.class,id).getBody();
        assert fakeStoreProductDto != null;
        return getProduct(fakeStoreProductDto);
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    private Product getProduct(FakeStoreProductDto fakeStoreProductDto){
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setName(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImageURL(fakeStoreProductDto.getImage());
        Category category = new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);
        return product;
    }
}