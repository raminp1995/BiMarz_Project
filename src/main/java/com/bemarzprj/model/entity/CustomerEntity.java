package com.bemarzprj.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
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

//    @OneToMany(mappedBy="customer")
//    private List<ProductEntity> products;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "depositInfo_id", referencedColumnName = "id")
    private DepositInfoEntity depositInfo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private OrderEntity order;
}
