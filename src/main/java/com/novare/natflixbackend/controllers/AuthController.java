package com.novare.natflixbackend.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.novare.natflixbackend.payload.request.LoginRequest;
import com.novare.natflixbackend.payload.request.SignupRequest;
import com.novare.natflixbackend.payload.response.MessageResponse;
import com.novare.natflixbackend.payload.response.UserInfoResponse;
import com.novare.natflixbackend.repository.RoleRepository;
import com.novare.natflixbackend.repository.UserRepository;
import com.novare.natflixbackend.security.jwt.JwtUtils;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.novare.natflixbackend.models.ERole;
import com.novare.natflixbackend.models.Role;
import com.novare.natflixbackend.models.User;
import com.novare.natflixbackend.security.services.UserDetailsImpl;

import static com.novare.natflixbackend.models.ERole.ROLE_ADMIN;
import static com.novare.natflixbackend.models.ERole.ROLE_CUSTOMER;

//for Angular Client (withCredentials)
//@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
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
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("/login")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);

    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

    ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());
    UserInfoResponse response=new UserInfoResponse(userDetails.getId(),
            userDetails.getUsername(),
            userDetails.getFullName(),
            roles);
    //There is just one role in this project so add it to the response
    switch (roles.get(0)) {
      case "ROLE_ADMIN" -> response.setType(1);
      case "ROLE_CUSTOMER" -> response.setType(2);
      default ->
              throw new IllegalArgumentException("Unexpected value: " + roles.get(0));
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
                         encoder.encode(signUpRequest.getPassword()));
    Set<Role> roles = new HashSet<>();
    Role userRole = roleRepository.findByName(ROLE_CUSTOMER)
            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
    roles.add(userRole);
    user.setRoles(roles);
    userRepository.save(user);
    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }

  @PostMapping("/logout")
  public ResponseEntity<?> logoutUser() {
    ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
        .body(new MessageResponse("You've been signed out!"));
  }
}
