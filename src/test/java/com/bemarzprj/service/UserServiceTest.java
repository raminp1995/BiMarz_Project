package com.bemarzprj.service;

import com.bemarzprj.exception.ExceptionMassages;
import com.bemarzprj.model.dto.UserDto;
import com.bemarzprj.model.entity.Role;
import com.bemarzprj.model.entity.UserEntity;
import com.bemarzprj.repository.IUserRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@ExtendWith(MockitoExtension.class)
public class UserServiceTest
{
    @Mock
    private IUserRepository userRepository;
    @InjectMocks
    private UserService2 userService;

    private UserEntity userEntity;
    private UserDto userDto;

    @Before
    public void init()
    {
        userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setRoles(List.of(new Role(2L, "USER")));
        userEntity.setUsername("Test");
        userEntity.setPassword("1234");

        userDto = new UserDto();
        userDto.setId(1L);
        userDto.setRoles(List.of(new Role(2L, "USER")));
        userDto.setUsername("Test");
        userDto.setPassword("1234");
    }

    @Test
    public void UserService_CreateUser_ReturnsUserDto() throws ExceptionMassages
    {
        //Arrange
        when(userRepository.save(Mockito.any(UserEntity.class))).thenReturn(userEntity);

        //Act
        UserDto savedUserdto = userService.create(userDto).getBody();

        //Assert
        Assertions.assertThat(savedUserdto).isNotNull();
    }

    @Test
    public void UserService_GetAllUser_ReturnsUserDto() throws ExceptionMassages
    {
        List<UserEntity> users = Mockito.mock(List.class);

        when(userRepository.findAll()).thenReturn(users);

        List<UserDto> savedUserDto = userService.getAll().getBody();

        Assertions.assertThat(savedUserDto).isNotNull();

    }

    @Test
    public void UserService_GetById_ReturnsUserDto() throws ExceptionMassages
    {
        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(userEntity));
        when(userRepository.save(Mockito.any(UserEntity.class))).thenReturn(userEntity);

        UserDto savedUserDto = userService.getById(1L).getBody();

        Assertions.assertThat(savedUserDto).isNotNull();
    }


    @Test
    public void UserService_UpdateUser_ReturnsUserDto() throws ExceptionMassages
    {
        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(userEntity));
        when(userRepository.save(Mockito.any(UserEntity.class))).thenReturn(userEntity);

        UserDto savedUserDto = userService.update(userDto).getBody();

        Assertions.assertThat(savedUserDto).isNotNull();
    }

    @Test
    public void UserService_DeleteUser_ReturnsVoid() throws ExceptionMassages
    {

        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(userEntity));

        assertAll(() -> userService.delete(1L));
    }
}
