package com.bemarzprj.service;

import com.bemarzprj.exception.ExceptionMassages;
import com.bemarzprj.mapper.IBaseMapper;
import com.bemarzprj.mapper.IUserMapper;
import com.bemarzprj.model.dto.UserDto;
import com.bemarzprj.model.entity.Role;
import com.bemarzprj.model.entity.UserEntity;
import com.bemarzprj.repository.IBaseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.beans.PropertyDescriptor;
import java.time.LocalDateTime;
import java.util.*;


public class BaseService2 implements IBaseService2
{
    private final IBaseRepository<UserEntity> baseRepository;
    private final IBaseMapper<UserEntity, UserDto> baseMapper = new IBaseMapper<UserEntity, UserDto>()
    {
        @Override
        public UserEntity dtoToEntity(UserDto dto)
        {
            if ( dto == null ) {
                return null;
            }

            UserEntity userEntity = new UserEntity();

            userEntity.setId( dto.getId() );
            userEntity.setCreated_at( dto.getCreated_at() );
            userEntity.setUpdated_at( dto.getUpdated_at() );
            userEntity.setDeleted( dto.getDeleted() );
            userEntity.setFirstName( dto.getFirstName() );
            userEntity.setLastName( dto.getLastName() );
            userEntity.setPhone( dto.getPhone() );
            List<Role> list = dto.getRoles();
            if ( list != null ) {
                userEntity.setRoles( new ArrayList<Role>( list ) );
            }
            Map<String, Boolean> map = dto.getUserAbilities();
            if ( map != null ) {
                userEntity.setUserAbilities( new LinkedHashMap<String, Boolean>( map ) );
            }
            userEntity.setUsername( dto.getUsername() );
            userEntity.setPassword( dto.getPassword() );

            return userEntity;
        }

        @Override
        public UserDto entityToDto(UserEntity entity)
        {
            if ( entity == null ) {
                return null;
            }

            UserDto userDto = new UserDto();

            userDto.setId( entity.getId() );
            userDto.setCreated_at( entity.getCreated_at() );
            userDto.setUpdated_at( entity.getUpdated_at() );
            userDto.setDeleted( entity.getDeleted() );
            userDto.setFirstName( entity.getFirstName() );
            userDto.setLastName( entity.getLastName() );
            userDto.setPhone( entity.getPhone() );
            List<Role> list = entity.getRoles();
            if ( list != null ) {
                userDto.setRoles( new ArrayList<Role>( list ) );
            }
            userDto.setUsername( entity.getUsername() );
            userDto.setPassword( entity.getPassword() );
            Map<String, Boolean> map = entity.getUserAbilities();
            if ( map != null ) {
                userDto.setUserAbilities( new LinkedHashMap<String, Boolean>( map ) );
            }

            return userDto;
        }
    };

    public BaseService2(IBaseRepository<UserEntity> baseRepository, IBaseMapper<UserEntity, UserDto> baseMapper)
    {
        this.baseRepository = baseRepository;
    }


    @Override
    public ResponseEntity<UserDto> getById(Long id) throws ExceptionMassages
    {
        UserDto dto = baseMapper.entityToDto(baseRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No Data Founded!")));

        if (dto.getDeleted())
        {
            throw new ExceptionMassages("Item not found!");
        }
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserDto>> getAll() throws ExceptionMassages
    {
        List<UserDto> dto =  baseRepository.findAll().stream().filter(i -> !i.getDeleted()).map(baseMapper::entityToDto).toList();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDto> create(UserDto dto) throws ExceptionMassages
    {
        dto.setCreated_at(LocalDateTime.now());
        UserDto resultDto = baseMapper.entityToDto(baseRepository.save(baseMapper.dtoToEntity(dto)));
        return new ResponseEntity<>(resultDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDto> update(UserDto dto) throws ExceptionMassages
    {
        UserEntity entity = baseRepository.findById(dto.getId()).orElseThrow(() -> new NoSuchElementException("Not found!"));
        entity.setUpdated_at(LocalDateTime.now());
        if (!entity.getDeleted())
        {
            copyNonNullProperties(dto, entity);
            return new ResponseEntity<>(baseMapper.entityToDto(baseRepository.save(entity)), HttpStatus.OK);
        }
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(Long id) throws ExceptionMassages
    {
        UserEntity entity = baseRepository.findById(id).orElseThrow(() -> new NoSuchElementException("No Data Founded!"));
        if (entity.getDeleted())
        {
            System.out.println("No information");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else
        {
            entity.setDeleted(true);
            baseRepository.save(entity);
            System.out.println("Your information successfully deleted!");
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }


    public static void copyNonNullProperties(Object source, Object target)
    {
        BeanUtils.copyProperties(source, target, getNullPropertyName(source));
    }

    public static String[] getNullPropertyName(Object source)
    {
        final BeanWrapper src = new BeanWrapperImpl(source);
        PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (PropertyDescriptor pd : pds)
        {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null)
            {
                emptyNames.add(pd.getName());
            }
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}

