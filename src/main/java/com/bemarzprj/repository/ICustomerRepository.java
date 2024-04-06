package com.bemarzprj.repository;

import com.bemarzprj.model.entity.CustomerEntity;
import com.bemarzprj.model.entity.PersonEntity;
import org.springframework.stereotype.Repository;

import java.beans.Transient;

@Repository
public interface ICustomerRepository extends IBaseRepository<CustomerEntity>
{
    @Transient
    @Override
    default CustomerEntity findByModel(String model)
    {
        return null;
    }
}
