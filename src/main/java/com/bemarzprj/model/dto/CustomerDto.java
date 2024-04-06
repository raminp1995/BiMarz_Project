package com.bemarzprj.model.dto;

import com.bemarzprj.model.entity.DepositInfoEntity;
import com.bemarzprj.model.entity.ProductEntity;
import com.bemarzprj.model.entity.ShippingInfo;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto extends PersonDto
{
    private String postCode;
    private String address;
    private String trackingCode;
    private String pageID;
    private List<ProductEntity> products;
    private DepositInfoEntity depositInfo;
    private ShippingInfo shippingInfo;
}
