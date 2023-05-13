package com.manish.spring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder

@NoArgsConstructor
@AllArgsConstructor

public class User {
    private String userId;
    private String fullName;
    private long phone;
    private String email;
    private String loginPassword;

    @Override
    public boolean equals(Object other){
        if (other == null)
            return false;
        if (other instanceof User) {
            User otherUser = (User) other;
            return this.getUserId().equals(otherUser.getUserId());
        }
        return false;
    }

}
