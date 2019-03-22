package com.huayutech.web.domain.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter @Setter
@Entity
@Table(name = "product_images")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler"})
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="product_fk")
    @JsonBackReference
    Product product;


    @Column
    String resourceUrl;

}
