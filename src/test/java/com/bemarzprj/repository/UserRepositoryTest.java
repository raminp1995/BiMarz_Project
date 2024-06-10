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
}
