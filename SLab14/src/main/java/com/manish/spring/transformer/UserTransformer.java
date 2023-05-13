package com.manish.spring.transformer;

import com.manish.spring.entity.UserEntity;
import com.manish.spring.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserTransformer {

    public static List<User> transformEntitiesToUser(List<UserEntity> userEntities){
        if(userEntities != null && userEntities.size() > 0) {
            List<User> users = new ArrayList<>(userEntities.size());
            for(UserEntity entity : userEntities){
                users.add(transformEntityToUser(entity));
            }
            return users;
        }
        return null;
    }

    public static User transformEntityToUser(UserEntity userEntity){
        if(userEntity != null) {
            User user = new User();
            user.setUserId(userEntity.getUserId());
            user.setFullName(userEntity.getFullName());
            user.setEmail(userEntity.getEmail());
            user.setPhone(userEntity.getPhone());
            user.setLoginPassword(userEntity.getLoginPassword());
            return user;
        }
        return null;
    }

    public static UserEntity transformUserToEntity(User user){
        if(user != null) {
            UserEntity entity = new UserEntity();
            entity.setUserId(user.getUserId());
            entity.setFullName(user.getFullName());
            entity.setEmail(user.getEmail());
            entity.setPhone(user.getPhone());
            entity.setLoginPassword(user.getLoginPassword());
            entity.setCreationDate(new Date());
            return entity;
        }
        return null;
    }

    public static void updateEntity(UserEntity entity, User user){
        if(user != null && entity != null) {
            entity.setUserId(user.getUserId());
            entity.setFullName(user.getFullName());
            entity.setEmail(user.getEmail());
            entity.setPhone(user.getPhone());
            entity.setLoginPassword(user.getLoginPassword());
        }
    }
}
