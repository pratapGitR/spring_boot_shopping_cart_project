package springmvc.model;

import lombok.Data;

@Data

public class UserModel {
    private Integer userId;
    private String userName;
    private String userEmail;
    private Number phoneNumber;
}
