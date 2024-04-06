package com.bemarzprj.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customers")
public class CustomerEntity extends PersonEntity
{
    @Column
    private String postCode;
    @Column
    private String address;
    @Column
    private String trackingCode;
    @Column
    private String pageID;

    @OneToMany(targetEntity = ProductEntity.class, cascade = CascadeType.ALL)
    private List<ProductEntity> products;

    @OneToOne(targetEntity = DepositInfoEntity.class, cascade = CascadeType.ALL)
    private DepositInfoEntity depositInfo;

    @OneToOne(targetEntity = DepositInfoEntity.class, cascade = CascadeType.ALL)
    private ShippingInfo shippingInfo;
}
