package com.huayutech.web.rest;

import com.huayutech.web.repository.category.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.huayutech.web.domain.category.ProductCategory;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @GetMapping("/{id}")
    public ProductCategory doGet(@PathVariable("id")Long id) {
        return productCategoryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

}
