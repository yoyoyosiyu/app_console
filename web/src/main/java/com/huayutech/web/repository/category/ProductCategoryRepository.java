package com.huayutech.web.repository.category;

import org.springframework.data.jpa.repository.JpaRepository;
import com.huayutech.web.domain.category.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
