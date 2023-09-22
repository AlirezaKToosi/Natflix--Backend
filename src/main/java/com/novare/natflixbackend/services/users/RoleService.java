package com.novare.natflixbackend.services.users;

import com.novare.natflixbackend.models.users.ERole;
import com.novare.natflixbackend.models.users.Role;
import com.novare.natflixbackend.repositories.users.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    public Optional<Role> getRoleByRoleName(ERole roleCustomer) {
        return roleRepository.findByName(roleCustomer);

    }
}
