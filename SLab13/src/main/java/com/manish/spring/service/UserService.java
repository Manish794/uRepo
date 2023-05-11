package com.manish.spring.service;


import com.manish.spring.model.Response;
import com.manish.spring.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class UserService {

    private List<User> users = new ArrayList<>();

    public Response<List<User>> getUsers() {
        log.info("UserService-> getUsers called");
        Response<List<User>> response = new Response();
        response.setData(users);
        return response;
    }

    public Response<User> addUser(User user) {
        log.info("UserService-> addUser called");
        Response<User> response = new Response<>();
        Response<User> exist = getUserByPhone(user.getPhone());
        if (exist.getData() !=null) {
            response.setStatus("ERROR");
            response.setErrorCode("UNABLE_T0_ADD_USER");
            response.setErrorMessage(user.getPhone() + " is already used");
        } else {
            exist = getUserByEmail(user.getEmail());
            if (exist.getData() != null) {
                response.setStatus("ERROR");
                response.setErrorCode("UNABLE_T0_ADD_USER");
                response.setErrorMessage(user.getEmail() + " is already used");
            } else {
                UUID uuid = UUID.randomUUID();
                user.setUserId(uuid.toString());
                users.add(user);
                response.setData(user);
            }
        }
        return response;
    }

    public Response<User> updateUser(User user) {
        log.info("UserService-> updateUser called");
        Response<User> response = new Response<>();
        Response<User> userToUpdate = getUserById(user.getUserId());
        if (userToUpdate.getData() !=null) {
            Response<User> searchedUser = getUserByPhone(user.getPhone());
            if (searchedUser.getData() !=null  && !searchedUser.getData().getUserId().equals(user.getUserId())) {
                response.setStatus("ERROR");
                response.setErrorCode("UNABLE_T0_UPDATE_USER");
                response.setErrorMessage(user.getPhone() + " is already used");
            } else {
                searchedUser = getUserByEmail(user.getEmail());
                if (searchedUser.getData() !=null  && !searchedUser.getData().getUserId().equals(user.getUserId())) {
                    response.setStatus("ERROR");
                    response.setErrorCode("UNABLE_T0_UPDATE_USER");
                    response.setErrorMessage(user.getEmail() + " is already used");
                } else {
                    users.remove(userToUpdate);
                    users.add(user);
                    response.setData(user);
                }
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
        Optional<User> optionalUser = users.stream().filter(user -> user.getPhone() == phone).findFirst();
        if (optionalUser.isPresent()) {
            response.setData(optionalUser.get());
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
        Optional<User> optionalUser = users.stream().filter(user -> user.getEmail().equals(email)).findFirst();
        if (optionalUser.isPresent()) {
            response.setData(optionalUser.get());
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
        Optional<User> optionalUser = users.stream().filter(user -> user.getUserId().equals(id)).findFirst();
        if (optionalUser.isPresent()) {
            response.setData(optionalUser.get());
        } else {
            response.setStatus("ERROR");
            response.setErrorCode("USER_NOT_FOUND");
            response.setErrorMessage("Not found with id "+ id);
        }
        return response;
    }

    public Response<Boolean> deleteUserById(String id) {
        log.info("UserService-> deleteUserById called");
        Response<Boolean> response = new Response<>();
        Optional<User> optionalUser = users.stream().filter(user -> user.getUserId().equals(id)).findFirst();
        if (optionalUser.isPresent()) {
            users.remove(optionalUser.get());
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
