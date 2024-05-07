package com.bemarzprj.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Mutability;
import org.springframework.data.jpa.repository.Lock;

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

    @OneToOne(targetEntity = DepositInfoEntity.class, mappedBy = "orderEntity")
    private DepositInfoEntity depositInfoEntity;

    private String postType;

    @ManyToOne(targetEntity = UserEntity.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @Immutable
    private UserEntity submitUser;

    private String printCode;

    private LocalDate dateOfPrint;

    private Boolean isPrinted;

    private String resultOfSend;

    private LocalDate dateOfSend;

    private String descriptions;

}
