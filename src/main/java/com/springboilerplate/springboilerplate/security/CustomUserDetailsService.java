package com.springboilerplate.springboilerplate.security;

import com.springboilerplate.springboilerplate.model.User;
import com.springboilerplate.springboilerplate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
public class CustomUserDetailsService implements CustomUserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.getByEmailAndDeletedFalse(username);
        if (optionalUser.isPresent()){
            return reflectLogin(optionalUser.get());
        }
        throw new UsernameNotFoundException("User with  '" + username + "' email not found.");
    }

    private User reflectLogin(User user) {
        user.setLastLogin(new Timestamp(System.currentTimeMillis()));
        return userRepository.saveAndFlush(user);
    }
}
