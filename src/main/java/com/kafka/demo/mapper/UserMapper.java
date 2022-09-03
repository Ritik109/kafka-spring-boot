package com.kafka.demo.mapper;

import com.kafka.demo.dto.UserKafkaDTO;
import com.kafka.demo.entity.User;

public class UserMapper {

    public static UserKafkaDTO toUserKafkaDTO(User user){
        UserKafkaDTO userKafkaDTO = new UserKafkaDTO();
        userKafkaDTO.setId(user.getId());
        userKafkaDTO.setName(user.getName());
        userKafkaDTO.setUserName(user.getUserName());
        return userKafkaDTO;
    }

}
