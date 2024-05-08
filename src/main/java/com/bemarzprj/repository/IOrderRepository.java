package com.bemarzprj.repository;

import com.bemarzprj.model.entity.OrderEntity;
import com.bemarzprj.model.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.beans.Transient;

@Repository
public interface IOrderRepository extends IBaseRepository<OrderEntity>
{

}
