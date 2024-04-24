package com.bemarzprj.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class OrderEntity extends BaseEntity
{
    @OneToOne(mappedBy = "order")
    private CustomerEntity customer;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProductEntity> products;

    private String postType;

    private Long submitter_id;

    private String printCode;

    private LocalDate dateOfPrint;

    private Boolean isPrinted;

    private String resultOfSend;

    private LocalDate dateOfSend;

    private String descriptions;

}
