package com.magatella.onlinestore.controllers;

import com.magatella.onlinestore.models.Cart;
import com.magatella.onlinestore.models.Product;
import com.magatella.onlinestore.models.User;
import com.magatella.onlinestore.services.CartService;
import com.magatella.onlinestore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @GetMapping("/list")
    public List<Product> productList(){
        return productService.allproducts();
    }

    @PostMapping("/add")
    public Product addProduct(){
        Product product = productService.generationDataProduct();
        productService.save(product);

        return product;
    }

    @PostMapping("/addcart")
    public void addCart(@RequestBody Product product,
                        @AuthenticationPrincipal User user,
                        Cart cart){
        cart.setUser(user);
        cart.setProducts(product);
        cartService.save(cart);
    }
}
