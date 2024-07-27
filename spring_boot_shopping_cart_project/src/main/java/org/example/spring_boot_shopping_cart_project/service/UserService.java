package org.example.spring_boot_shopping_cart_project.service;

import org.example.spring_boot_shopping_cart_project.entity.User;
import org.example.spring_boot_shopping_cart_project.model.UserModel;
import org.example.spring_boot_shopping_cart_project.repository.RoleRepo;
import org.example.spring_boot_shopping_cart_project.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private ModelMapper modelMapper;


    public String saveUser(UserModel userModel){
        User user = modelMapper.map(userModel, User.class);
        user.setUserPassword(passwordEncoder.encode(userModel.getUserPassword()));

        try {
            this.userRepo.save(user);
        } catch (Exception e) {
            System.err.println("Error :: "+e.getMessage());
            return "Not Saved";
        }
        return "Saved Successfully";
    }

    public List<UserModel> getAllUsers(){
        List<User> userList = this.userRepo.findAll();
        List<UserModel> userModels= userList.stream()
                .map(user -> modelMapper.map(user, UserModel.class)).toList();
        return userModels;
    }


    public List<UserModel> getByRoleName(String role){
        List<User> userList = this.userRepo.findByRolesName(role);
        List<UserModel> userModels= userList.stream()
                .map(user -> modelMapper.map(user, UserModel.class))
                .collect(Collectors.toList());
        return userModels;
    }

    public String deleteUser(String userEmail) {
        Optional<User> user = userRepo.findByUserEmail(userEmail);
        if (user.isPresent()) {
            userRepo.delete(user.get());
            return "Deleted Successfully";
        }else {
            return "Not Deleted";
        }
//        User userMapped = modelMapper.map(user, User.class);
//
//       if (userMapped != null){
//           userMapped.getRoles().clear();
//           userRepo.save(userMapped);
//           userRepo.delete(userMapped);
//           return "Deleted Successfully and associated roles are also deleted";
//       }else {
//           return "Not Deleted";
//       }

    }

    public String updateUser(UserModel userModel) {
        User user = modelMapper.map(userModel, User.class);
        user.setUserPassword(passwordEncoder.encode(userModel.getUserPassword()));
        try {
            this.userRepo.save(user);
        } catch (Exception e) {
            System.err.println("Error :: "+e.getMessage());
            return "Not Updated";
        }
        return "Updated Successfully";
    }

//    public String deleteDuplicateUser(UserModel userModel) {
//        Optional<List<User>> userList = this.userRepo.findByUserName(userModel.getUserName());
//        List<User> userMapped = userList.stream().map(user -> modelMapper.map(user, User.class)).collect(Collectors.toList());
//
//        if(userMapped.size()>=1){
//           User uniqueUser = (User) new HashSet<>(userMapped).stream().collect(Collectors.toList());
//            userRepo.save(uniqueUser);
//            return "Duplicate found and updated them to one user";
//        }else {
//            return "Could not find any duplicate user";
//        }
//
//    }
}
