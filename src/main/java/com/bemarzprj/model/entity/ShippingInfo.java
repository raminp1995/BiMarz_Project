package com.bemarzprj.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ShippingInfo extends BaseEntity
{
    @Column
    private String printCode;
    @Column
    private LocalDate printDate;
    @Column
    private Boolean isPrinted;
    @Column
    private Boolean isSent;
    @Column
    private LocalDate sentDate;
}
