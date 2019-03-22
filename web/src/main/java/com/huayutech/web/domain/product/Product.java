package com.huayutech.web.domain.product;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Setter @Getter
@Entity
@Table(name = "products")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler"})
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    Set<ProductImage> images = Collections.emptySet();

}
