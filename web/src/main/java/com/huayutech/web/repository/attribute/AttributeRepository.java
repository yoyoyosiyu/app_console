package com.huayutech.web.repository.attribute;

import com.huayutech.web.domain.attribute.Attribute;
import com.huayutech.web.domain.category.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttributeRepository extends JpaRepository<Attribute, Long> {

    List<Attribute> findAttributesByProductCategory(ProductCategory productCategory);

}
