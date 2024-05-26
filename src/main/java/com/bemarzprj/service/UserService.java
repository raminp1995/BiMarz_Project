package com.bemarzprj.service;

import com.bemarzprj.constants.Abilities;
import com.bemarzprj.constants.RoleType;
import com.bemarzprj.exception.ExceptionMassages;
import com.bemarzprj.mapper.IBaseMapper;
import com.bemarzprj.mapper.IUserMapper;
import com.bemarzprj.model.dto.UserDto;
import com.bemarzprj.model.entity.Role;
import com.bemarzprj.model.entity.UserEntity;
import com.bemarzprj.repository.IBaseRepository;
import com.bemarzprj.repository.IUserRepository;
import com.bemarzprj.security.SecurityConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class UserService extends BaseService<UserEntity, UserDto>
{
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final IUserMapper userMapper;
    public UserService(IBaseRepository<UserEntity> baseRepository, IBaseMapper<UserEntity, UserDto> baseMapper, IUserRepository userRepository, PasswordEncoder passwordEncoder, IUserMapper userMapper)
    {
        super(baseRepository, baseMapper);
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Override
    public ResponseEntity<UserDto> getById(Long id) throws ExceptionMassages
    {
        if (checkPermission(Abilities.GET_USER))
        {
            return super.getById(id);
        }
        else
        {
            throw new ExceptionMassages("You can not operate this action");
        }
    }

    @Override
    public ResponseEntity<List<UserDto>> getAll() throws ExceptionMassages
    {
        if (checkPermission(Abilities.GET_USER))
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

//        if (checkPermission(Abilities.ADD_USER))
//        {
            if (dto.getRoles().getFirst().getName().equals(RoleType.OWNER))
            {
                setOwnerDefaultAbilities(dto);
            }
            else if (dto.getRoles().getFirst().getName().equals(RoleType.ADMIN))
            {
                setAdminDefaultAbilities(dto);
            }
            else if (dto.getRoles().getFirst().getName().equals(RoleType.USER))
            {
                setUserDefaultAbilities(dto);
            }
//            dto.setPassword(passwordEncoder.encode(dto.getPassword()));
            return super.create(dto);
//        }
//        else
//        {
//            throw new ExceptionMassages("You can not operate this action");
//        }
    }

    @Override
    public ResponseEntity<UserDto> update(UserDto dto) throws ExceptionMassages
    {

        if (checkPermission(Abilities.EDIT_USER))
        {
            UserDto userDto = findUserByUsername(dto.getUsername()).getBody();
            assert userDto != null;
            dto.setId(userDto.getId());

            if (dto.getUserAbilities().isEmpty())
            {
                dto.setUserAbilities(userDto.getUserAbilities());
            }

            if (dto.getRoles().isEmpty())
            {
                dto.setRoles(userDto.getRoles());
            }
            else
            {
                if (dto.getRoles().getFirst().getName().equals(RoleType.OWNER))
                {
                    setOwnerDefaultAbilities(dto);
                }
                else if (dto.getRoles().getFirst().getName().equals(RoleType.ADMIN))
                {
                    setAdminDefaultAbilities(dto);
                }
                else if (dto.getRoles().getFirst().getName().equals(RoleType.USER))
                {
                    setUserDefaultAbilities(dto);
                }
            }

            if (dto.getPassword() != null)
            {
                dto.setPassword(passwordEncoder.encode(dto.getPassword()));
            }


            return super.update(dto);

        }
        else
        {
            throw new ExceptionMassages("You can not operate this action");
        }
    }

    @Override
    public ResponseEntity<Void> delete(Long id) throws ExceptionMassages
    {
        if (checkPermission(Abilities.REMOVE_USER))
        {
            super.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
        {
            throw new ExceptionMassages("You can not operate this action");
        }
    }

    public UserEntity findByUsername(String username)
    {
        return userRepository.findByUsername(username).orElseThrow(() -> new NoSuchElementException("User not Found!"));

    }


    public void setOwnerDefaultAbilities(UserDto dto)
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
        userAbilities.put("ADD_PRODUCT",true);
        userAbilities.put("EDIT_PRODUCT", true);
        userAbilities.put("REMOVE_PRODUCT", true);
        userAbilities.put("GET_PRODUCT", true);
        userAbilities.put("ADD_ORDER",true);
        userAbilities.put("EDIT_ORDER", true);
        userAbilities.put("REMOVE_ORDER", true);
        userAbilities.put("GET_ORDER", true);

        dto.setUserAbilities(userAbilities);
        //return dto;
    }
    public void setAdminDefaultAbilities(UserDto dto)
    {
        Map<String, Boolean> userAbilities = new HashMap<>();
//        userAbilities.put("ADD_ADMIN",true);
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
        userAbilities.put("ADD_PRODUCT",true);
        userAbilities.put("EDIT_PRODUCT", true);
        userAbilities.put("REMOVE_PRODUCT", true);
        userAbilities.put("GET_PRODUCT", true);
        userAbilities.put("ADD_ORDER",true);
        userAbilities.put("EDIT_ORDER", true);
        userAbilities.put("REMOVE_ORDER", true);
        userAbilities.put("GET_ORDER", true);

        dto.setUserAbilities(userAbilities);
        //return dto;
    }

    private void setUserDefaultAbilities(UserDto dto)
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
        //return dto;
    }

    /*
    This method checks the Permission of a user
 */
    public Boolean checkPermission(String ability)
    {
        String username = SecurityConstants.getAuth().getName();
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found!"));

        Role roles = user.getRoles().getFirst();
        if (roles.getName().equalsIgnoreCase(RoleType.OWNER)
                || roles.getName().equalsIgnoreCase(RoleType.ADMIN)
                || roles.getName().equalsIgnoreCase(RoleType.USER))
        {
            return user.getUserAbilities().get(ability);
        }
        return false;
    }

    public boolean existsByUsername(String username)
    {
        return userRepository.existsByUsername(username);
    }

    public ResponseEntity<UserDto> findUserByUsername (String username)
    {
        return new ResponseEntity<>(userMapper.entityToDto(
                        userRepository.findByUsername(username)
                                .orElseThrow(() -> new NoSuchElementException("User not Found!"))), HttpStatus.OK);
    }
}
