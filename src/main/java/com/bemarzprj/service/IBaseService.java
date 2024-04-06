package com.bemarzprj.service;

import com.bemarzprj.model.dto.BaseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBaseService<Dto extends BaseDto>
{
    ResponseEntity<Dto> getById(Long id);

    ResponseEntity<Dto> getByModel(String model);

    ResponseEntity<List<Dto>> getAll();

    ResponseEntity<Dto> create(Dto dto);

    ResponseEntity<Dto> update(Dto dto);

    void delete(Long id);
}
