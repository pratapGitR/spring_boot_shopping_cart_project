package springmvc.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springmvc.dao.UserDAO;
import springmvc.entity.User;
import springmvc.model.UserModel;
import springmvc.utility.ReadData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service

public class UserService {
    @Autowired
    private ReadData readData;
    @Autowired
    private UserDAO userDAO;
    public void saveUserData (UserModel userModel){
        User user = new User();
        user.setUserId(userModel.getUserId());
        user.setUserName(userModel.getUserName());
        user.setUserEmail(userModel.getUserEmail());
        user.setPhoneNumber(userModel.getPhoneNumber());
        this.userDAO.saveUser(user);
    }
    public List<UserModel>getAllUserData(){
        List<UserModel>data = new ArrayList<>();
        File file = new File("userInfo.xlsx");

        data = readData.fetchAllUserData();
        return data;

    }
}
