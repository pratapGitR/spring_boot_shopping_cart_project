package org.example.spring_boot_shopping_cart_project.model;

import lombok.Data;
import org.example.spring_boot_shopping_cart_project.entity.Role;

import java.util.Set;

@Data
public class UserModel {

    private String userName;
    private String userEmail;
    private Long userMobile;
    private String userAddress;
    private String  userUserName;
    private String userPassword;

    private Set<RoleModel> roles;


}
