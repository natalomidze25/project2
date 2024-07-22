package com.skillwill.groupProject2.validator;

import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    public void validateUser(String username){
        if(!username.equals("user")){
            throw new RuntimeException( "you dont have permission");
        }
    }

    public void validateAdmin(String username){
        if(!username.equals("admin")){
            throw new RuntimeException( "you dont have permission");
        }
    }

}
