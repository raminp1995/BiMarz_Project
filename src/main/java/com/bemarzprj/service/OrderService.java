package com.bemarzprj.service;

import com.bemarzprj.constants.Abilities;
import com.bemarzprj.exception.ExceptionMassages;
import com.bemarzprj.mapper.IBaseMapper;
import com.bemarzprj.model.dto.OrderDto;
import com.bemarzprj.model.entity.OrderEntity;
import com.bemarzprj.repository.IBaseRepository;
import com.bemarzprj.repository.IUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService extends BaseService<OrderEntity, OrderDto>
{
    public OrderService(IBaseRepository<OrderEntity> baseRepository, IUserRepository userRepository, IBaseMapper<OrderEntity, OrderDto> baseMapper)
    {
        super(baseRepository, userRepository, baseMapper);
    }


    @Override
    public ResponseEntity<OrderDto> getById(Long id) throws ExceptionMassages
    {
        if (super.checkPermission(Abilities.GET_ORDER))
        {
            return super.getById(id);
        }
        else
        {
            throw new ExceptionMassages("You can not operate this action");
        }
    }

    @Override
    public ResponseEntity<OrderDto> getByModel(String model)
    {
        return super.getByModel(model);
    }

    @Override
    public ResponseEntity<List<OrderDto>> getAll() throws ExceptionMassages
    {
        if (super.checkPermission(Abilities.GET_ORDER))
        {
            return super.getAll();
        }
        else
        {
            throw new ExceptionMassages("You can not operate this action");
        }
    }

    @Override
    public ResponseEntity<OrderDto> create(OrderDto dto) throws ExceptionMassages
    {

        if (super.checkPermission(Abilities.ADD_ORDER))
        {
            return super.create(dto);
        }
        else
        {
            throw new ExceptionMassages("You can not operate this action");
        }
    }

    @Override
    public ResponseEntity<OrderDto> update(OrderDto dto) throws ExceptionMassages
    {
        if (super.checkPermission(Abilities.EDIT_ORDER))
        {
            return super.update(dto);
        }
        else
        {
            throw new ExceptionMassages("You can not operate this action");
        }
    }

    @Override
    public ResponseEntity<Boolean> delete(Long id) throws ExceptionMassages
    {
        if (super.checkPermission(Abilities.REMOVE_ORDER))
        {
            super.delete(id);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        else
        {
            throw new ExceptionMassages("You can not operate this action");
        }
    }
}
