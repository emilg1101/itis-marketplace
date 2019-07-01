package com.github.emilg1101.marketplace.service;

import com.github.emilg1101.marketplace.data.entity.User;
import com.github.emilg1101.marketplace.data.repository.UserRepository;
import com.github.emilg1101.marketplace.exception.UserAlreadyExistsException;
import com.github.emilg1101.marketplace.exception.WrongEmailOrPasswordException;
import com.github.emilg1101.marketplace.model.form.RegistrationForm;
import com.github.emilg1101.marketplace.model.form.SigninForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService userDetailsService;

    public User login(SigninForm form) {
        User user = (User) userDetailsService.loadUserByUsername(form.getEmail());
        if (!passwordEncoder.matches(form.getPassword(), user.getPassword())) {
            throw new WrongEmailOrPasswordException();
        }
        return user;
    }

    public User register(RegistrationForm form) {
        Optional<User> userCandidate = userRepository.findByEmail(form.getEmail());
        if (userCandidate.isPresent()) {
            throw new UserAlreadyExistsException();
        }

        User user = User.builder()
                .email(form.getEmail())
                .name(form.getName())
                .password(passwordEncoder.encode(form.getPassword()))
                .regDate(Date.from(Instant.now()))
                .build();
        return userRepository.save(user);
    }
}
