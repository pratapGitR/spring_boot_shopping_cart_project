package org.pratap.spring_security_jwt.security;

import org.pratap.spring_security_jwt.entity.User;
import org.pratap.spring_security_jwt.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userdata = userRepo.findByName(username);
        if(userdata.isPresent()){
            return (UserDetails)userdata.get();
        }
        else{
            throw new UsernameNotFoundException("User not found");
        }
    }
}
