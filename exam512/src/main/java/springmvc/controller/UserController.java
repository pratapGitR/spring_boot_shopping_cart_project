package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import springmvc.model.UserModel;
import springmvc.service.UserService;

@Controller

public class UserController {
    @Autowired
    private UserService userService;
    public String saveUserInfo(@ModelAttribute UserModel userModel){
        System.out.println("user model "+userModel);
        this.userService.saveUserData(userModel);
        return null;
    }


}