package com.bemarzprj.service;

import com.bemarzprj.constants.Abilities;
import com.bemarzprj.exception.ExceptionMassages;
import com.bemarzprj.mapper.IBaseMapper;
import com.bemarzprj.mapper.IUserMapper;
import com.bemarzprj.model.dto.OrderDto;
import com.bemarzprj.model.entity.OrderEntity;
import com.bemarzprj.model.entity.UserEntity;
import com.bemarzprj.repository.IBaseRepository;
import com.bemarzprj.repository.IUserRepository;
import com.bemarzprj.security.SecurityConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderService extends BaseService<OrderEntity, OrderDto>
{
    private final UserService userService;
    private final IUserRepository userRepository;
    private final IUserMapper userMapper;
    public OrderService(IBaseRepository<OrderEntity> baseRepository, IBaseMapper<OrderEntity, OrderDto> baseMapper, UserService userService, IUserRepository userRepository, IUserMapper userMapper)
    {
        super(baseRepository, baseMapper);
        this.userService = userService;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public ResponseEntity<OrderDto> getById(Long id) throws ExceptionMassages
    {
        if (userService.checkPermission(Abilities.GET_ORDER))
        {
            return super.getById(id);
        }
        else
        {
            throw new ExceptionMassages("You can not operate this action");
        }
    }

    @Override
    public ResponseEntity<List<OrderDto>> getAll() throws ExceptionMassages
    {
        if (userService.checkPermission(Abilities.GET_ORDER))
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
        UserEntity user = userRepository.findByUsername(dto.getSubmitUser().getUsername()).orElseThrow(() -> new NoSuchElementException("No User!"));
        String user2 = SecurityConstants.getAuth().getName();

        if (user2.equalsIgnoreCase(user.getUsername()))
        {
            if (userService.checkPermission(Abilities.ADD_ORDER))
            {
                dto.setSubmitUser(userMapper.entityToDto(user));
                return super.create(dto);
            }
            else
            {
                throw new ExceptionMassages("You can not operate this action");
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<OrderDto> update(OrderDto dto) throws ExceptionMassages
    {
        UserEntity user = userRepository.findByUsername(dto.getSubmitUser().getUsername()).orElseThrow(() -> new NoSuchElementException("No User!"));
        String user2 = SecurityConstants.getAuth().getName();

        if (user2.equalsIgnoreCase(user.getUsername()))
        {
            if (userService.checkPermission(Abilities.EDIT_ORDER))
            {
                dto.setSubmitUser(userMapper.entityToDto(user));
                return super.update(dto);
            }
            else
            {
                throw new ExceptionMassages("You can not operate this action");
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Void> delete(Long id) throws ExceptionMassages
    {
        if (userService.checkPermission(Abilities.REMOVE_ORDER))
        {
            super.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
        {
            throw new ExceptionMassages("You can not operate this action");
        }
    }
}
