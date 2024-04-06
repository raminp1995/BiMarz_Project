package com.bemarzprj.model.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepositInfoEntity extends BaseEntity
{
    private LocalDate date;
    private LocalDateTime time;
    private Long price;
    private Byte cardNum;
    private Boolean isDeposit;
}
