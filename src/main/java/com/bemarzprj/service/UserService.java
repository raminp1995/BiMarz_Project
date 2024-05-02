package com.bemarzprj.service;

import com.bemarzprj.constants.Abilities;
import com.bemarzprj.constants.RoleType;
import com.bemarzprj.exception.ExceptionMassages;
import com.bemarzprj.mapper.IBaseMapper;
import com.bemarzprj.model.dto.UserDto;
import com.bemarzprj.model.entity.UserEntity;
import com.bemarzprj.repository.IBaseRepository;
import com.bemarzprj.repository.IUserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService extends BaseService<UserEntity, UserDto>
{
    private final PasswordEncoder passwordEncoder;
    public UserService(IBaseRepository<UserEntity> baseRepository, IUserRepository userRepository, IBaseMapper<UserEntity, UserDto> baseMapper, PasswordEncoder passwordEncoder)
    {
        super(baseRepository, userRepository, baseMapper);
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ResponseEntity<UserDto> getById(Long id) throws ExceptionMassages
    {
        if (super.checkPermission(Abilities.GET_USER))
        {
            return super.getById(id);
        }
        else
        {
            throw new ExceptionMassages("You can not operate this action");
        }
    }

    @Override
    public ResponseEntity<UserDto> getByModel(String model)
    {
        return super.getByModel(model);
    }

    @Override
    public ResponseEntity<List<UserDto>> getAll() throws ExceptionMassages
    {
        if (super.checkPermission(Abilities.GET_USER))
        {
            return super.getAll();
        }
        else
        {
            throw new ExceptionMassages("You can not operate this action");
        }
    }

    @Override
    public ResponseEntity<UserDto> create(UserDto dto) throws ExceptionMassages
    {
        UserDto user = new UserDto();

        if (super.checkPermission(Abilities.ADD_USER))
        {
            if (dto.getRoles().getFirst().getName().equals(RoleType.ADMIN))
            {
                user = setAdminDefaultAbilities(dto);
            }
            else if (dto.getRoles().getFirst().getName().equals(RoleType.USER))
            {
                user = setUserDefaultAbilities(dto);
            }
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
            return super.create(user);
        }
        else
        {
            throw new ExceptionMassages("You can not operate this action");
        }
    }

    @Override
    public ResponseEntity<UserDto> update(UserDto dto) throws ExceptionMassages
    {
        if (super.checkPermission(Abilities.EDIT_USER))
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
        if (super.checkPermission(Abilities.REMOVE_USER))
        {
            super.delete(id);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        else
        {
            throw new ExceptionMassages("You can not operate this action");
        }
    }


    private UserDto setAdminDefaultAbilities(UserDto dto)
    {
        Map<String, Boolean> userAbilities = new HashMap<>();
        userAbilities.put("ADD_ADMIN",true);
        userAbilities.put("EDIT_ADMIN", true);
        userAbilities.put("REMOVE_ADMIN", true);
        userAbilities.put("GET_ADMIN", true);
        userAbilities.put("ADD_USER",true);
        userAbilities.put("EDIT_USER", true);
        userAbilities.put("REMOVE_USER", true);
        userAbilities.put("GET_USER", true);
        userAbilities.put("ADD_CUSTOMER",true);
        userAbilities.put("EDIT_CUSTOMER", true);
        userAbilities.put("REMOVE_CUSTOMER", true);
        userAbilities.put("GET_CUSTOMER", true);
        userAbilities.put("ADD_Product",true);
        userAbilities.put("EDIT_PRODUCT", true);
        userAbilities.put("REMOVE_PRODUCT", true);
        userAbilities.put("GET_PRODUCT", true);
        userAbilities.put("ADD_ORDER",true);
        userAbilities.put("EDIT_ORDER", true);
        userAbilities.put("REMOVE_ORDER", true);
        userAbilities.put("GET_ORDER", true);

        dto.setUserAbilities(userAbilities);
        return dto;
    }

    private UserDto setUserDefaultAbilities(UserDto dto)
    {
        Map<String, Boolean> userAbilities = new HashMap<>();
        userAbilities.put("ADD_CUSTOMER",true);
        userAbilities.put("EDIT_CUSTOMER", true);
        userAbilities.put("GET_CUSTOMER", true);
        userAbilities.put("GET_PRODUCT", true);
        userAbilities.put("ADD_ORDER",true);
        userAbilities.put("EDIT_ORDER", true);
        userAbilities.put("REMOVE_ORDER", true);
        userAbilities.put("GET_ORDER", true);

        dto.setUserAbilities(userAbilities);
        return dto;
    }
}
