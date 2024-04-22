package com.bemarzprj.model.dto;


import com.bemarzprj.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends PersonDto
{
    private List<Role> roles = new ArrayList<>();

    private String username;
    private String password;

    private Boolean addAdmin = false;
    private Boolean editAdmin = false;
    private Boolean removeAdmin = false;
    private Boolean addUser = false;
    private Boolean editUser = false;
    private Boolean removeUser = false;
    private Boolean addProduct = false;
    private Boolean editProduct = false;
    private Boolean removeProduct = false;
    private Boolean addOrder = false;
    private Boolean editOrder = false;
    private Boolean removeOrder = false;
}
