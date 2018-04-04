package com.springboilerplate.springboilerplate.service;

import com.springboilerplate.springboilerplate.constants.EnvironmentConstants;
import com.springboilerplate.springboilerplate.dto.MailData;
import com.springboilerplate.springboilerplate.dto.UserDto;
import com.springboilerplate.springboilerplate.enums.RoleType;
import com.springboilerplate.springboilerplate.exceptions.UserNotInDBException;
import com.springboilerplate.springboilerplate.mapper.UserDtoMapper;
import com.springboilerplate.springboilerplate.message.MailSender;
import com.springboilerplate.springboilerplate.model.Role;
import com.springboilerplate.springboilerplate.model.User;
import com.springboilerplate.springboilerplate.repository.RoleRepository;
import com.springboilerplate.springboilerplate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;
import org.apache.commons.lang.RandomStringUtils;

import javax.mail.MessagingException;
import java.util.Optional;

import static com.springboilerplate.springboilerplate.constants.MailConstants.*;


@Service
public class UserServiceImpl implements UserService{
    private Environment environment;
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private UserDtoMapper userDtoMapper;
    private MailSender mailSender;

    @Autowired
    public UserServiceImpl(Environment environment, RoleRepository roleRepository,
                           UserRepository userRepository, UserDtoMapper userDtoMapper, MailSender mailSender) {
        this.environment = environment;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.userDtoMapper = userDtoMapper;
        this.mailSender = mailSender;
    }

    @Override
    public User saveUser(UserDto userDto, RoleType roleType) {
        User user = userDtoMapper.toUser(userDto);
        encodeAndSetUserPassword(user);
        return setUserRole(user, roleType);
    }

    @Override
    public User resetPassword(String email) throws UserNotInDBException, MessagingException {
        User user = userRepository.findByEmailEqualsAndDeletedFalse(email);
        if (user == null) {
            throw new UserNotInDBException("User with email address could not be found in db");
        }
        String newPassword = RandomStringUtils.random(8, true, false);
        user.setPassword(newPassword);
        encodeAndSetUserPassword(user);
        user.setResetPassword(true);
        user = userRepository.saveAndFlush(user);
        String me = PROFILE_RESET_MESSAGE_1;
        String ss = String.format(PROFILE_RESET_MESSAGE_2, user.getFirstname());
        String a = String.format(PROFILE_RESET_MESSAGE_3, newPassword);
        String ge = PROFILE_RESET_MESSAGE_4;
        mailSender.sendMail(user.getEmail(), me+ss+a+ge, PROFILE_RESET_SUBJECT);
        return user;
    }

    private void encodeAndSetUserPassword(User user){
        String passwordKey = environment.getProperty(EnvironmentConstants.PASSWORD_KEY);
        StandardPasswordEncoder encoder = new StandardPasswordEncoder(passwordKey);
        user.setPassword(encoder.encode(user.getPassword().trim()));
    }

    private User setUserRole(User user, RoleType roleType){
        Optional<Role> optionalRole = roleRepository.findByName(roleType.name());
        optionalRole.ifPresent(user::setRole);
        return userRepository.saveAndFlush(user);
    }
}
