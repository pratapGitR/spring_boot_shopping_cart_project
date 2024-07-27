package org.pratap.spring_security_jwt.dto;

import lombok.Data;
import org.pratap.spring_security_jwt.entity.Role;

import java.util.Set;

@Data
public class UserDTO {

    private String name;
    private String email;
    private String password;
    private Set<Role> roles;
}
