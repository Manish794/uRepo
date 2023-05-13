package com.manish.spring.service;


import com.manish.spring.entity.UserEntity;
import com.manish.spring.model.Response;
import com.manish.spring.model.User;
import com.manish.spring.repo.UserRepo;
import com.manish.spring.transformer.UserTransformer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public Response<List<User>> getUsers() {
        log.info("UserService-> getUsers called");
        Response<List<User>> response = new Response();
        List<UserEntity> entities = userRepo.findAll();
        if(entities == null || entities.size()==0){
            response.setStatus("ERROR");
            response.setErrorCode("USER_NOT_FOUND");
            response.setErrorMessage("Not User found ");
        } else {
            response.setData(UserTransformer.transformEntitiesToUser(entities));
        }
        return response;
    }

    @Transactional
    public Response<User> addUser(User user) {
        log.info("UserService-> addUser called");
        Response<User> response = new Response<>();
        List<UserEntity> entities = userRepo.findAllByPhoneOrEmail(user.getPhone(), user.getEmail());
        if (entities !=null && entities.size() > 0) {
            response.setStatus("ERROR");
            response.setErrorCode("UNABLE_T0_ADD_USER");
            response.setErrorMessage("Phone or email is already used");
        } else {
            UserEntity entity= userRepo.save(UserTransformer.transformUserToEntity(user));
            response.setData(UserTransformer.transformEntityToUser(entity));
        }
        return response;
    }

    @Transactional
    public Response<User> updateUser(User user) {
        log.info("UserService-> updateUser called");
        Response<User> response = new Response<>();
        Optional<UserEntity> userToUpdate = userRepo.findById(user.getUserId());
        if (userToUpdate.isPresent()) {
            List<UserEntity> entities = userRepo.findAllByPhoneOrEmail(user.getPhone(), user.getEmail());
            if(entities == null || entities.size() == 0) {
                UserEntity entity = userToUpdate.get();
                UserTransformer.updateEntity(entity, user);
                userRepo.save(entity);
            } else if(entities.size() == 1){
                    if(entities.get(0) != null && entities.get(0).getUserId().equals(user.getUserId())) {
                        UserEntity entity = userToUpdate.get();
                        UserTransformer.updateEntity(entity, user);
                        userRepo.save(entity);
                    } else {
                        response.setStatus("ERROR");
                        response.setErrorCode("UNABLE_T0_ADD_USER");
                        response.setErrorMessage("Phone or email is already used");
                    }
            } else {
                response.setStatus("ERROR");
                response.setErrorCode("UNABLE_T0_ADD_USER");
                response.setErrorMessage("Phone or email is already used");
            }
        } else {
            response.setStatus("ERROR");
            response.setErrorCode("USER_NOT_FOUND");
            response.setErrorMessage("Not found with id "+ user.getUserId());
        }
        return response;
    }

    public Response<User> getUserByPhone(long phone) {
        log.info("UserService-> getUserByPhone called");
        Response<User> response = new Response<>();
        UserEntity userEntity = userRepo.findUserEntityByPhone(phone);
        if (userEntity != null) {
            response.setData(UserTransformer.transformEntityToUser(userEntity));
        } else {
            response.setStatus("ERROR");
            response.setErrorCode("USER_NOT_FOUND");
            response.setErrorMessage("Not found with phone "+ phone);
        }
        return response;
    }

    public Response<User> getUserByEmail(String email) {
        log.info("UserService-> getUserByEmail called");
        Response<User> response = new Response<>();
        UserEntity userEntity = userRepo.findUserEntityByEmail(email);
        if (userEntity != null) {
            response.setData(UserTransformer.transformEntityToUser(userEntity));
        } else {
            response.setStatus("ERROR");
            response.setErrorCode("USER_NOT_FOUND");
            response.setErrorMessage("Not found with email "+ email);
        }
        return response;
    }

    public Response<User> getUserById(String id) {
        log.info("UserService-> getUserById called");
        Response<User> response = new Response<>();
        Optional<UserEntity> userEntity = userRepo.findById(id);
        if (userEntity.isPresent()) {
            response.setData(UserTransformer.transformEntityToUser(userEntity.get()));
        } else {
            response.setStatus("ERROR");
            response.setErrorCode("USER_NOT_FOUND");
            response.setErrorMessage("Not found with id "+ id);
        }
        return response;
    }

    @Transactional
    public Response<Boolean> deleteUserById(String id) {
        log.info("UserService-> deleteUserById called");
        Response<Boolean> response = new Response<>();
        Optional<UserEntity> userEntity = userRepo.findById(id);
        if (userEntity.isPresent()) {
            userRepo.deleteById(id);
            response.setData(true);
        } else {
            response.setStatus("ERROR");
            response.setErrorCode("USER_NOT_FOUND");
            response.setErrorMessage("Not found with id "+ id);
            response.setData(false);
        }
        return response;
    }

}
