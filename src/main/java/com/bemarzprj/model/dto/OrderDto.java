package com.bemarzprj.model.dto;

import com.bemarzprj.model.entity.CustomerEntity;
import com.bemarzprj.model.entity.ProductEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto extends BaseDto
{
    private CustomerEntity customer;
    private List<ProductEntity> products;
    private String postType;
    private UserDto submitUser;
    private String printCode;
    private LocalDate dateOfPrint;
    private Boolean isPrinted;
    private String resultOfSend;
    private LocalDate dateOfSend;
    private String descriptions;
}
