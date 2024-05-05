package com.bemarzprj.model.dto;


import com.bemarzprj.model.entity.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends PersonDto
{
    private List<Role> roles = new ArrayList<>();
    private String username;
    private String password;
    private Map<String, Boolean> userAbilities = new HashMap<>();
}
