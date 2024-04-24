package com.bemarzprj.service;

import com.bemarzprj.constants.RoleType;
import com.bemarzprj.mapper.IBaseMapper;
import com.bemarzprj.model.dto.UserDto;
import com.bemarzprj.model.entity.UserEntity;
import com.bemarzprj.repository.IBaseRepository;
import com.bemarzprj.repository.IRoleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends BaseService<UserEntity, UserDto>
{
    private final IRoleRepository roleRepository;
    public UserService(IBaseRepository<UserEntity> baseRepository, IBaseMapper<UserEntity, UserDto> baseMapper, IRoleRepository roleRepository)
    {
        super(baseRepository, baseMapper);
        this.roleRepository = roleRepository;
    }

    @Override
    public ResponseEntity<UserDto> getById(Long id)
    {
        return super.getById(id);
    }

    @Override
    public ResponseEntity<UserDto> getByModel(String model)
    {
        return super.getByModel(model);
    }

    @Override
    public ResponseEntity<List<UserDto>> getAll()
    {
        return super.getAll();
    }

    @Override
    public ResponseEntity<UserDto> create(UserDto dto)
    {
        UserDto userDto = setDefaultAbilities(dto);

        return super.create(userDto);
    }

    @Override
    public ResponseEntity<UserDto> update(UserDto dto)
    {
        return super.update(dto);
    }

    @Override
    public void delete(Long id)
    {
        super.delete(id);
    }

    private UserDto setDefaultAbilities(UserDto dto)
    {
        String role = roleRepository.findById(dto.getRoles().getFirst().getId()).get().getName();
        if (role.equals(RoleType.ADMIN))
        {
            dto.setAddUser(true);
            dto.setEditUser(true);
            dto.setRemoveUser(true);
            dto.setAddProduct(true);
            dto.setEditProduct(true);
            dto.setRemoveProduct(true);
            dto.setAddOrder(true);
            dto.setRemoveOrder(true);
            dto.setEditOrder(true);

        }
        else if (role.equals(RoleType.USER))
        {
            dto.setAddProduct(true);
            dto.setEditProduct(true);
            dto.setRemoveProduct(true);
            dto.setAddOrder(true);
        }

        return dto;
    }
}
