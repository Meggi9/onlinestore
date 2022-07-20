package com.magatella.onlinestore.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_table")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nameProd")
    private String nameProd;

    @Column(name = "price")
    private Float price;

    @Column(name = "stock")
    private Integer stock;
}
