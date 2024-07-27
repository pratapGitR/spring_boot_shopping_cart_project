package org.example.spring_boot_shopping_cart_project.service;

import org.example.spring_boot_shopping_cart_project.entity.User;
import org.example.spring_boot_shopping_cart_project.repository.UserRepo;
import org.example.spring_boot_shopping_cart_project.security.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userdata = userRepo.findByUserName(username);
        if (userdata.isPresent()) {
            return new MyUserDetailsService(userdata.get().getUserName(), userdata.get().getUserPassword(), userdata.get().getRoles());
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
