package com.springboilerplate.springboilerplate.service;

import com.springboilerplate.springboilerplate.dto.UserDto;
import com.springboilerplate.springboilerplate.enums.RoleType;
import com.springboilerplate.springboilerplate.exceptions.UserNotInDBException;
import com.springboilerplate.springboilerplate.model.User;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;

@Transactional
public interface UserService {

    User saveUser(UserDto userDto, RoleType roleType);
    User resetPassword(String email) throws UserNotInDBException, MessagingException;
}
