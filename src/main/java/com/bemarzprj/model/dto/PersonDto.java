package com.bemarzprj.model.dto;

import com.bemarzprj.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto extends BaseDto
{
    private String firstName;
    private String lastName;
//    private String username;
//    private String password;
    private String phone;
    private Role rule;
}
