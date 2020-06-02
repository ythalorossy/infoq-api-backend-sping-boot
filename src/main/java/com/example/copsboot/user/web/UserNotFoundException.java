package com.example.copsboot.user.web;

import com.example.copsboot.user.UserId;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(UserId userId) {
        super(String.format("Could not find user with id %s", userId.asString()));
    }
}
