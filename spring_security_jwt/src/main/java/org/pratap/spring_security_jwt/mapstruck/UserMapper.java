package org.pratap.spring_security_jwt.mapstruck;

import org.mapstruct.Mapper;
import org.pratap.spring_security_jwt.dto.UserDTO;
import org.pratap.spring_security_jwt.entity.User;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = org.mapstruct.factory.Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);

    User userDTOToUser(UserDTO userDTO);
}
