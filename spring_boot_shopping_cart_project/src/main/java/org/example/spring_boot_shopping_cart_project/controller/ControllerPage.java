package org.example.spring_boot_shopping_cart_project.controller;

import org.example.spring_boot_shopping_cart_project.Login.LoginRequest;
import org.example.spring_boot_shopping_cart_project.Login.LoginResp;
import org.example.spring_boot_shopping_cart_project.jwt.JwtUtils;
import org.example.spring_boot_shopping_cart_project.model.UserModel;
import org.example.spring_boot_shopping_cart_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/shopping/user")
public class ControllerPage {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtils jwtUtils;


   private AuthenticationManager authenticationManager;

    public ControllerPage(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @PreAuthorize("permitAll()")
    @PostMapping("/register")
    public ResponseEntity<String>saveUser(@RequestBody UserModel userModel){
        if(userModel!=null){
            return ResponseEntity.ok(userService.saveUser(userModel));
        }else {
            return ResponseEntity.ok("Data not saved");
        }
    }
//    @PreAuthorize("hasRole('ADMIN')")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/getAllUsers")
   public ResponseEntity<List<UserModel>>getAllUsers(){
       return ResponseEntity.ok(userService.getAllUsers());
   }

   @PreAuthorize("hasAuthority('ADMIN')")
   @GetMapping("/getUserByRole/{role}")
   public ResponseEntity<List<UserModel>> getRoleByName(@PathVariable String role){
        return ResponseEntity.ok(userService.getByRoleName(role));
   }
   @PreAuthorize("permitAll()")
    @DeleteMapping("/deleteUser/{userEmail}")
    public ResponseEntity<String> deleteUser(@PathVariable String userEmail){
        return ResponseEntity.ok(userService.deleteUser(userEmail));
    }
    @PreAuthorize("permitAll()")
    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUser(@RequestBody UserModel userModel){
        return ResponseEntity.ok(userService.updateUser(userModel));
    }
//    @PreAuthorize("permitAll()")
//    @PostMapping("/deleteDuplicateUser")
//    public ResponseEntity<String> deleteDuplicateUser(@RequestBody UserModel userModel){
//        return ResponseEntity.ok(userService.deleteDuplicateUser(userModel));
//    }
    @PreAuthorize("permitAll()")
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest){
       Authentication authentication;
        try{
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUserName(),loginRequest.getPassword()));
        }catch (AuthenticationException e){
            Map<String, Object> error = new HashMap<>();
            error.put("message", e.getMessage());
            error.put("status", false);

            return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails= (UserDetails) authentication.getPrincipal();

        String jwtToken = jwtUtils.generateTokenFromUserName(userDetails);

        List<String>roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();

        LoginResp loginResp = new LoginResp(userDetails.getUsername(),jwtToken,roles);
        return ResponseEntity.ok(loginResp);
    }
}
