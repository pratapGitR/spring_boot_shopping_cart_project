package org.example.spring_boot_shopping_cart_project.security;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.spring_boot_shopping_cart_project.entity.Role;
import org.example.spring_boot_shopping_cart_project.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
public class MyUserDetailsService implements UserDetails {
    private String userName;
    private String userPassword;
    private Set<Role> roles;




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        for(Role roles : roles) {
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority(roles.getRoleName()));

        }

        return simpleGrantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.userPassword;
    }

    @Override
    public String getUsername() {
       return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}





