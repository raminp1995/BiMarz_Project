package com.bemarzprj.repository;

import com.bemarzprj.model.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.beans.Transient;
import java.util.Optional;

@Repository
public interface IUserRepository extends IBaseRepository<UserEntity>
{
    @Transient
    @Override
    default UserEntity findByModel(String model)
    {
        return null;
    }

    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
}
