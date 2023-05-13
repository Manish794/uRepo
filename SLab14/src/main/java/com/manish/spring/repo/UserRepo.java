package com.manish.spring.repo;

import com.manish.spring.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, String> {
        UserEntity findUserEntityByPhone(long phone);
        UserEntity findUserEntityByEmail(String email);
        List<UserEntity> findAllByPhoneOrEmail(long phone, String email);
}
