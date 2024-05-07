package com.bemarzprj.controller;

import com.bemarzprj.exception.ExceptionMassages;
import com.bemarzprj.mapper.IUserMapper;
import com.bemarzprj.model.dto.AuthResponseDto;
import com.bemarzprj.model.dto.LoginDto;
import com.bemarzprj.model.dto.RegisterDto;
import com.bemarzprj.model.dto.UserDto;
import com.bemarzprj.model.entity.Role;
import com.bemarzprj.model.entity.UserEntity;
import com.bemarzprj.repository.IRoleRepository;
import com.bemarzprj.repository.IUserRepository;
import com.bemarzprj.security.JWTGenerator;
import com.bemarzprj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/auth")
public class AuthController
{
    private final AuthenticationManager authenticationManager;

//    private final IUserRepository userRepository;

    private final UserService userService;
    private final IUserMapper userMapper;
    private final IRoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTGenerator jwtGenerator;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserService userService, IUserMapper userMapper, /*IUserRepository userRepository,*/ IRoleRepository roleRepository, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator)
    {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.userMapper = userMapper;
//        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) throws ExceptionMassages
    {
        if(userService.existsByUsername(registerDto.getUsername()))
        {
            return new ResponseEntity<>("Username is taken!!", HttpStatus.BAD_REQUEST);
        }

        UserEntity user = new UserEntity();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));

        Role roles = roleRepository.findByName("OWNER").get();
        user.setRoles(Collections.singletonList(roles));
        UserDto userDto = userService.setAdminDefaultAbilities(userMapper.entityToDto(user));
        userService.create(userDto);

        return new ResponseEntity<>("User Registration was Successful", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto)
    {
        UserEntity user = userService.findByUsername(loginDto.getUsername());
        if (user.getDeleted())
        {
            throw new NoSuchElementException("User not found!");
        }
        else
        {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String token = jwtGenerator.generatorToken(authentication);

            return new ResponseEntity<>(new AuthResponseDto(token), HttpStatus.OK);
        }
    }

}
