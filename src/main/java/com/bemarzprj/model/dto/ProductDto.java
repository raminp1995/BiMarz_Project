package com.bemarzprj.model.dto;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto extends BaseDto
{
    private String model;
    private String size;
    private String color;
    private Integer price;
    private Integer quantity;
}
