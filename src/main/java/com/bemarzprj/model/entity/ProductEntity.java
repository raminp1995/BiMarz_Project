package com.bemarzprj.model.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity extends BaseEntity
{
    private ProductType productType;
    private String model;
    private String size;
    private String color;
    private Integer price;
    private Integer quantity;
    private Integer count;
}
