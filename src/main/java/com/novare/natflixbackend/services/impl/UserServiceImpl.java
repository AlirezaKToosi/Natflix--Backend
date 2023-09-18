package com.novare.natflixbackend.services.impl;

import com.novare.natflixbackend.exceptions.BackEndException;
import com.novare.natflixbackend.models.Role;
import com.novare.natflixbackend.models.User;
import com.novare.natflixbackend.repository.RoleRepository;
import com.novare.natflixbackend.repository.UserRepository;
import com.novare.natflixbackend.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

import static com.novare.natflixbackend.models.ERole.ROLE_CUSTOMER;


@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User createUser(User user) throws BackEndException {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(ROLE_CUSTOMER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);
        user.setRoles(roles);
        return userRepository.save(user);
    }
}