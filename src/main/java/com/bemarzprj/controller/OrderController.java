package com.bemarzprj.controller;

import com.bemarzprj.model.dto.OrderDto;
import com.bemarzprj.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController extends BaseController<OrderService, OrderDto>
{
    protected OrderController(OrderService service)
    {
        super(service);
    }

    @GetMapping("/getById/{id}")
    @Override
    ResponseEntity<OrderDto> getById(@PathVariable Long id)
    {
        return super.getById(id);
    }

    @Override
    ResponseEntity<OrderDto> getByModel(String model)
    {
        return super.getByModel(model);
    }

    @GetMapping("/getAll")
    @Override
    ResponseEntity<List<OrderDto>> getAll()
    {
        return super.getAll();
    }

    @PostMapping("/create")
    @Override
    ResponseEntity<OrderDto> create(@RequestBody OrderDto dto)
    {
        return super.create(dto);
    }

    @PutMapping("/update")
    @Override
    ResponseEntity<OrderDto> update(@RequestBody OrderDto dto)
    {
        return super.update(dto);
    }

    @DeleteMapping("/delete/{id}")
    @Override
    void delete(@PathVariable Long id)
    {
        super.delete(id);
    }
}
