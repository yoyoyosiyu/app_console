package com.huayutech.web.repository.product;

import com.huayutech.web.domain.product.Product;
import com.huayutech.web.domain.product.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

    List<ProductImage> findAllByProduct(Product product);
}
