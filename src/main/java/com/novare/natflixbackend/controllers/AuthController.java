package com.novare.natflixbackend.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.novare.natflixbackend.payload.request.LoginRequest;
import com.novare.natflixbackend.payload.request.SignupRequest;
import com.novare.natflixbackend.payload.response.MessageResponse;
import com.novare.natflixbackend.payload.response.UserInfoResponse;
import com.novare.natflixbackend.repository.RoleRepository;
import com.novare.natflixbackend.repository.UserRepository;
import com.novare.natflixbackend.security.jwt.JwtUtils;
import com.novare.natflixbackend.services.IUserService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.novare.natflixbackend.models.User;
import com.novare.natflixbackend.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        UserInfoResponse response = new UserInfoResponse(userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getFullName(),
                roles);
        //There is just one role in this project so add it to the response
        switch (roles.get(0)) {
            case "ROLE_ADMIN" -> response.setType(1);
            case "ROLE_CUSTOMER" -> response.setType(2);
            default -> throw new IllegalArgumentException("Unexpected value: " + roles.get(0));
        }

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString()).body(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }
        // Create new user's account
        User user = new User(signUpRequest.getName(),
                signUpRequest.getEmail(),
                signUpRequest.getPassword());
        final User createUser = userService.createUser(user);
        List<String> roles = createUser.getRoles().stream()
                .map(item -> item.getName().name())
                .collect(Collectors.toList());
        UserInfoResponse response = new UserInfoResponse(createUser.getId(),
                createUser.getEmail(),
                createUser.getFullName(),
                roles);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponse("You've been signed out!"));
    }
}
