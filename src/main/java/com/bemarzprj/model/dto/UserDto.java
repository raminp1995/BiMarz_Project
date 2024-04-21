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
    private Boolean addUser;
    private Boolean editUser;
    private Boolean removeUser;
    private Boolean addProduct;
    private Boolean editeProduct;
    private Boolean removeProduct;
}
