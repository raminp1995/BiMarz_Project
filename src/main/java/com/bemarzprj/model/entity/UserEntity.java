package com.bemarzprj.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

@AllArgsConstructor
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

    @ElementCollection
    @MapKeyColumn(name="userAbilities")
    @Column(name="value")
    @CollectionTable(name="ability_isAble", joinColumns=@JoinColumn(name="userAbilities_id"))
    private Map<String, Boolean> userAbilities = new HashMap<>();

    @Column(unique = true, nullable = false)
    @NotNull
    private String username;

    @Column(nullable = false)
    private String password;

    public UserEntity()
    {
        userAbilities.put("ADD_ADMIN",false);
        userAbilities.put("EDIT_ADMIN", false);
        userAbilities.put("REMOVE_ADMIN", false);
        userAbilities.put("GET_ADMIN", false);
        userAbilities.put("ADD_USER",false);
        userAbilities.put("EDIT_USER", false);
        userAbilities.put("REMOVE_USER", false);
        userAbilities.put("GET_USER", false);
        userAbilities.put("ADD_CUSTOMER",false);
        userAbilities.put("EDIT_CUSTOMER", false);
        userAbilities.put("REMOVE_CUSTOMER", false);
        userAbilities.put("GET_CUSTOMER", false);
        userAbilities.put("ADD_Product",false);
        userAbilities.put("EDIT_PRODUCT", false);
        userAbilities.put("REMOVE_PRODUCT", false);
        userAbilities.put("GET_PRODUCT", false);
        userAbilities.put("ADD_ORDER",false);
        userAbilities.put("EDIT_ORDER", false);
        userAbilities.put("REMOVE_ORDER", false);
        userAbilities.put("GET_ORDER", false);
    }

}
