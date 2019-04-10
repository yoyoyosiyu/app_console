package com.huayutech.web.rest.category;

import com.huayutech.web.domain.attribute.Attribute;
import com.huayutech.web.domain.category.ProductCategory;
import com.huayutech.web.repository.attribute.AttributeRepository;
import com.huayutech.web.repository.category.ProductCategoryRepository;
import com.huayutech.web.service.category.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/${url.api.prefix:/api}/categories/{categoryId}/attributes")
public class CategoryAttributeController {

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Autowired
    AttributeRepository attributeRepository;

    @Autowired
    ProductCategoryService productCategoryService;

    @PostMapping
    public void doPost(@PathVariable(name = "categoryId") Long categoryId, @RequestBody Attribute attribute) {

        ProductCategory productCategory = productCategoryRepository.findById(categoryId).orElseThrow(EntityNotFoundException::new);

        attribute.setProductCategory(productCategory);

        attributeRepository.save(attribute);

    }

    @GetMapping
    public List<Attribute> doGet(@PathVariable Long categoryId) {

        return productCategoryService.GetCategoryAttributes(categoryId, true);
    }


}
