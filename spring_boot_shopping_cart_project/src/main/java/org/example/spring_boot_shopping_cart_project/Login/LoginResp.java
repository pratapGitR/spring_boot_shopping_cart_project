package org.example.spring_boot_shopping_cart_project.Login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResp {

    private String userName;
    private String jwtToken;
    private List<String>roles;
}
