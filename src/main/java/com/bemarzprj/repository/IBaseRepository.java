package com.bemarzprj.repository;

import com.bemarzprj.model.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface IBaseRepository<E extends BaseEntity> extends JpaRepository<E, Long>
{

}
