package com.novare.natflixbackend.services.users;

import com.novare.natflixbackend.exceptions.BackEndException;
import com.novare.natflixbackend.models.users.Role;
import com.novare.natflixbackend.models.users.User;
import com.novare.natflixbackend.repositories.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

import static com.novare.natflixbackend.models.users.ERole.ROLE_CUSTOMER;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleService roleService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User createUserWithCustomerRole(User user) throws BackEndException {
        user.setPassword(encodePassword(user.getPassword()));
        Role customerRole = getOrCreateCustomerRole();
        user.setRoles(Collections.singleton(customerRole));
        return saveUser(user);
    }

    private String encodePassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    private Role getOrCreateCustomerRole() throws RuntimeException {
        return roleService.getRoleByRoleName(ROLE_CUSTOMER)
                .orElseThrow(() -> new RuntimeException("Error: Role 'ROLE_CUSTOMER' not found."));
    }

    private User saveUser(User user) {
        return userRepository.save(user);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}