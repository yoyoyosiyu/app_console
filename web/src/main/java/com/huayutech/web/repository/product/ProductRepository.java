package com.huayutech.web.repository.product;

import com.huayutech.web.domain.product.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}
