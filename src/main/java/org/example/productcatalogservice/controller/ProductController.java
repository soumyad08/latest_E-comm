package org.example.productcatalogservice.controller;
import org.example.productcatalogservice.dtos.CategoryDto;
import org.example.productcatalogservice.dtos.ProductDto;
import org.example.productcatalogservice.models.Product;
import org.example.productcatalogservice.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    public IProductService productService;

    @GetMapping("/products")
    public List<ProductDto> getProduct(){
        return null;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity <ProductDto> getProductById(@PathVariable("id") Long productId){
        try {
            if(productId == null || productId <= 0){
                throw new IllegalArgumentException("Product Id is invalid");
            }
            Product product = productService.getProductById(Math.toIntExact(productId));
            ProductDto productDto = new ProductDto();
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add("Accept", "application/json");
            return new ResponseEntity<>(productDto,headers,HttpStatus.OK);
        }catch (IllegalArgumentException exception){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/products")
    public ProductDto createProduct(@RequestBody ProductDto product){
        return null;
    }

    private ProductDto getProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setImageURL(product.getImageURL());
        productDto.setDescription(product.getDescription());
        if(product.getCategory() != null) {
            CategoryDto category = new CategoryDto();
            category.setId(product.getCategory().getId());
            category.setName(product.getCategory().getName());
            productDto.setCategory(category);
        }
        return productDto;
    }
}
