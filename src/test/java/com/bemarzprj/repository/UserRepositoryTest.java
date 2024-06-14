package com.bemarzprj.repository;

import com.bemarzprj.model.entity.Role;
import com.bemarzprj.model.entity.UserEntity;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTest
{

    @Autowired
    private IUserRepository userRepository;

    @Test
    public void UserRepository_SaveAll_ReturnSavedUser()
    {
        //Arrange
        UserEntity user = new UserEntity();
        user.setId(1L);
        user.setRoles(List.of(new Role(2L, "USER")));
        user.setUsername("Test");
        user.setPassword("1234");

        //Act
        UserEntity savedUser = userRepository.save(user);

        //Assert
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0L);
    }

    @Test
    public void UserRepository_GetAll_ReturnMoreThenOneUser()
    {
        UserEntity user1 = new UserEntity();
        user1.setId(1L);
        user1.setRoles(List.of(new Role(2L, "USER")));
        user1.setUsername("Test1");
        user1.setPassword("1234");

        UserEntity user2 = new UserEntity();
        user2.setId(2L);
        user2.setRoles(List.of(new Role(2L, "USER")));
        user2.setUsername("Test2");
        user2.setPassword("1234");

        userRepository.save(user1);
        userRepository.save(user2);

        List<UserEntity> userEntityList = userRepository.findAll();

        Assertions.assertThat(userEntityList).isNotNull();
        Assertions.assertThat(userEntityList.size()).isEqualTo(2);
    }

    @Test
    public void UserRepository_FindById_ReturnUser()
    {
        UserEntity user1 = new UserEntity();
        user1.setId(1L);
        user1.setRoles(List.of(new Role(2L, "USER")));
        user1.setUsername("Test1");
        user1.setPassword("1234");

        userRepository.save(user1);

        UserEntity userEntityList = userRepository.findById(user1.getId()).get();

        Assertions.assertThat(userEntityList).isNotNull();
    }

    @Test
    public void UserRepository_FindByUsername_ReturnUser()
    {
        //Arrange
        UserEntity user1 = new UserEntity();
        user1.setId(1L);
        user1.setRoles(List.of(new Role(2L, "USER")));
        user1.setUsername("Test1");
        user1.setPassword("1234");

        userRepository.save(user1);

        //Act
        UserEntity userEntityList = userRepository.findByUsername(user1.getUsername()).get();

        //Assert
        Assertions.assertThat(userEntityList).isNotNull();
    }

    @Test
    public void UserRepository_UpdateUser_ReturnUserNotNull()
    {
        UserEntity user1 = new UserEntity();
        user1.setId(1L);
        user1.setRoles(List.of(new Role(2L, "USER")));
        user1.setUsername("Test1");
        user1.setPassword("1234");

        userRepository.save(user1);

        UserEntity savedUser = userRepository.findById(user1.getId()).get();

        savedUser.setUsername("Test2");
        savedUser.setPassword("123");

        UserEntity updatedUser = userRepository.save(savedUser);

        Assertions.assertThat(updatedUser.getUsername()).isNotNull();
        Assertions.assertThat(updatedUser.getPassword()).isNotNull();
    }

    @Test
    public void UserRepository_DeleteUser_ReturnUserIsEmpty()
    {
        //Arrange
        UserEntity user1 = new UserEntity();
        user1.setId(1L);
        user1.setRoles(List.of(new Role(2L, "USER")));
        user1.setUsername("Test");
        user1.setPassword("1234");

        userRepository.save(user1);

        //Act
        userRepository.deleteById(user1.getId());

        Optional<UserEntity> userReturn = userRepository.findById(user1.getId());

        //Assert
        Assertions.assertThat(userReturn).isEmpty();
    }


}
