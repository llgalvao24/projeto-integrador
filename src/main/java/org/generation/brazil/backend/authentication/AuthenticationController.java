package org.generation.brazil.backend.authentication;

import java.net.URI;
import java.util.Collections;
import javax.validation.Valid;

import org.generation.brazil.backend.address.Address;
import org.generation.brazil.backend.exception.BackendException;
import org.generation.brazil.backend.role.Role;
import org.generation.brazil.backend.role.RoleName;
import org.generation.brazil.backend.role.RoleRepository;
import org.generation.brazil.backend.security.LoginRequest;
import org.generation.brazil.backend.security.SignUpRequest;
import org.generation.brazil.backend.security.jwt.JwtAuthenticationResponse;
import org.generation.brazil.backend.security.jwt.JwtTokenProvider;
import org.generation.brazil.backend.user.User;
import org.generation.brazil.backend.user.UserNewDTO;
import org.generation.brazil.backend.user.UserRepository;
import org.generation.brazil.backend.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private JwtTokenProvider tokenProvider;

  @Autowired
  private UserService service;

  @PostMapping("/sign-in")
  public ResponseEntity<JwtAuthenticationResponse> authenticateUser(
      @Valid @RequestBody LoginRequest loginRequest) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            loginRequest.getUsernameOrEmail(),
            loginRequest.getPassword()
        )
    );

    SecurityContextHolder.getContext().setAuthentication(authentication);

    String jwt = tokenProvider.generateToken(authentication);
    return ResponseEntity.ok(new JwtAuthenticationResponse(jwt, "Bearer"));
  }

  @PostMapping("/sign-up")
  public ResponseEntity<AuthenticationResponse> registerUser(
      @Valid @RequestBody SignUpRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername()) || userRepository
        .existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity.badRequest()
          .body(new AuthenticationResponse(false, "Username or E-mail Address already in use."));
    }

    Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
        .orElseThrow(() -> new BackendException("User Role not set."));

    // Creating user's account.
    UserNewDTO objDTO = new UserNewDTO();

    objDTO.setName(signUpRequest.getName());
    objDTO.setEmail(signUpRequest.getEmail());
    objDTO.setCpf(signUpRequest.getCpf());
    objDTO.setBirthDate(signUpRequest.getBirthDate());
    objDTO.setPhone(signUpRequest.getPhone());
    objDTO.setImageUrl(signUpRequest.getImageUrl());

    objDTO.setStreetName(signUpRequest.getStreetName());
    objDTO.setStreetNumber(signUpRequest.getStreetNumber());
    objDTO.setReference(signUpRequest.getReference());
    objDTO.setNeighbourhood(signUpRequest.getNeighbourhood());
    objDTO.setZipCode(signUpRequest.getZipCode());
    objDTO.setCity(signUpRequest.getCity());
    objDTO.setState(signUpRequest.getState());

    objDTO.setUsername(signUpRequest.getUsername());
    objDTO.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));

    User obj = service.fromDTO(objDTO);

    obj.setRoles(Collections.singleton(userRole));

    URI location = ServletUriComponentsBuilder
        .fromCurrentContextPath().path("/users/{username}")
        .buildAndExpand(userRepository.save(obj).getUsername()).toUri();

    return ResponseEntity.created(location)
        .body(new AuthenticationResponse(true, "User registered successfully."));
  }
}
