//package com.bemarzprj.security;
//
//import com.bemarzprj.model.entity.Role;
//import com.bemarzprj.model.entity.UserEntity;
//import com.bemarzprj.repository.IUserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Collection;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class CustomUserDetailService implements UserDetailsService
//{
//    private final IUserRepository userRepository;
//
//    @Autowired
//    public CustomUserDetailService(IUserRepository userRepository)
//    {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
//    {
//        UserEntity user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
//        return new User(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
//    }
//
//    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles)
//    {
//        return roles.stream()
//                .map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//    }
//}
