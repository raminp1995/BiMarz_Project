package com.bemarzprj.service;

import com.bemarzprj.constants.RoleType;
import com.bemarzprj.exception.ExceptionMassages;
import com.bemarzprj.mapper.IBaseMapper;
import com.bemarzprj.model.dto.BaseDto;
import com.bemarzprj.model.entity.BaseEntity;
import com.bemarzprj.model.entity.Role;
import com.bemarzprj.model.entity.UserEntity;
import com.bemarzprj.repository.IBaseRepository;
import com.bemarzprj.repository.IUserRepository;
import com.bemarzprj.security.SecurityConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.NoSuchElementException;


public class BaseService<E extends BaseEntity, Dto extends BaseDto> implements IBaseService<Dto>
{
    private final IBaseRepository<E> baseRepository;
    private final IUserRepository userRepository;
    private final IBaseMapper<E, Dto> baseMapper;

    public BaseService(IBaseRepository<E> baseRepository, IUserRepository userRepository, IBaseMapper<E, Dto> baseMapper)
    {
        this.baseRepository = baseRepository;
        this.userRepository = userRepository;
        this.baseMapper = baseMapper;
    }


    @Override
    public ResponseEntity<Dto> getById(Long id) throws ExceptionMassages
    {
        Dto dto = baseMapper.entityToDto(baseRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No Data Founded!")));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Dto> getByModel(String model)
    {
        Dto dto = baseMapper.entityToDto(baseRepository.findByModel(model));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Dto>> getAll() throws ExceptionMassages
    {
        List<Dto> dto =  baseRepository.findAll().stream().map(baseMapper::entityToDto).toList();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Dto> create(Dto dto) throws ExceptionMassages
    {
        Dto resultDto = baseMapper.entityToDto(baseRepository.save(baseMapper.dtoToEntity(dto)));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Dto> update(Dto dto) throws ExceptionMassages
    {
        Dto resultDto = baseMapper.entityToDto(baseRepository.save(baseMapper.dtoToEntity(dto)));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Boolean> delete(Long id) throws ExceptionMassages
    {

        return null;
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
        if (roles.getName().equalsIgnoreCase(RoleType.ADMIN) || roles.getName().equalsIgnoreCase(RoleType.USER))
        {
            return user.getUserAbilities().get(ability);
        }
        return false;
    }
}
