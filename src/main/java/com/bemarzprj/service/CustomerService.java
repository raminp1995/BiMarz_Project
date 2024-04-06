package com.bemarzprj.service;

import com.bemarzprj.mapper.IBaseMapper;
import com.bemarzprj.model.dto.CustomerDto;
import com.bemarzprj.model.entity.CustomerEntity;
import com.bemarzprj.repository.IBaseRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends BaseService<CustomerEntity, CustomerDto>
{
    public CustomerService(IBaseRepository<CustomerEntity> baseRepository, IBaseMapper<CustomerEntity, CustomerDto> baseMapper)
    {
        super(baseRepository, baseMapper);
    }
}
