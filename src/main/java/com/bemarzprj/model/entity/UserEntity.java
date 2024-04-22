package com.bemarzprj.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity extends PersonEntity
{
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
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
