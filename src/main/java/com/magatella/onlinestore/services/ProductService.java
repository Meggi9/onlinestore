package com.magatella.onlinestore.services;

import com.github.javafaker.Faker;
import com.magatella.onlinestore.models.Product;
import com.magatella.onlinestore.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> allproducts(){
        return productRepository.findAll();
    }

    public void save(Product product){productRepository.save(product);}

    public Product generationDataProduct() {
        Product product = new Product();
        Faker faker = new Faker(new Locale("ru"));

        product.setNameProd(faker.commerce().productName());
        product.setStock((int)(Math.random() * 100));
        product.setPrice(Float.parseFloat(faker.commerce().price().replace(",", ".")));

        return product;
    }
}
