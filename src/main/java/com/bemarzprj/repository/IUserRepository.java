package com.bemarzprj.repository;

import com.bemarzprj.model.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.beans.Transient;
import java.util.Optional;

@Repository
public interface IUserRepository extends IBaseRepository<UserEntity>
{
    Optional<UserEntity> findByUsername(String username);

    boolean existsByUsername(String username);


}
