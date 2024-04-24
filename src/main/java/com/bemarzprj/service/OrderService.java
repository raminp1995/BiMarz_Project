package com.bemarzprj.service;

import com.bemarzprj.mapper.IBaseMapper;
import com.bemarzprj.model.dto.OrderDto;
import com.bemarzprj.model.entity.OrderEntity;
import com.bemarzprj.repository.IBaseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService extends BaseService<OrderEntity, OrderDto>
{
    public OrderService(IBaseRepository<OrderEntity> baseRepository, IBaseMapper<OrderEntity, OrderDto> baseMapper)
    {
        super(baseRepository, baseMapper);
    }

    @Override
    public ResponseEntity<OrderDto> getById(Long id)
    {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<OrderDto> getByModel(String model)
    {
        return super.getByModel(model);
    }

    @Override
    public ResponseEntity<List<OrderDto>> getAll()
    {
        return super.getAll();
    }

    @Override
    public ResponseEntity<OrderDto> create(OrderDto dto)
    {
        return super.create(dto);
    }

    @Override
    public ResponseEntity<OrderDto> update(OrderDto dto)
    {
        return super.update(dto);
    }

    @Override
    public void delete(Long id)
    {
        super.delete(id);
    }
}
