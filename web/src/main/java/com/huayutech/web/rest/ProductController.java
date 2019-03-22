package com.huayutech.web.rest;


import com.huayutech.web.domain.product.Product;
import com.huayutech.web.domain.product.ProductImage;
import com.huayutech.web.repository.product.ProductImageRepository;
import com.huayutech.web.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductImageRepository productImageRepository;


    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping
    public void createProduct(@RequestBody Product product) {

        productRepository.save(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {

        Product product = productRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException(String.format("product with id %s does not exist", id)));
        return product;

    }


    @PostMapping("/{id}/images")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void addNewImageToProduct(@PathVariable(name = "id") Long productId, @RequestBody ProductImage productImage) {


        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new EntityNotFoundException(String.format("product with id %s does not exist", productId)));

        //productImage.setProduct(product);

        productImageRepository.save(productImage);
    }

    @GetMapping("/{id}/images")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<ProductImage> getImagesOfProduct(@PathVariable(name = "id") Long productId) {

        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new EntityNotFoundException(String.format("product with id %s does not exist", productId)));

        return productImageRepository.findAllByProduct(product);


    }


}
