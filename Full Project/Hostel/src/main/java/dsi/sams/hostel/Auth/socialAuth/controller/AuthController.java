package dsi.sams.hostel.Auth.socialAuth.controller;

import dsi.sams.hostel.AppUtil.exception.BadRequestException;
import dsi.sams.hostel.Auth.request.LoginRequest;
import dsi.sams.hostel.Auth.request.RegistrationRequest;
import dsi.sams.hostel.Auth.socialAuth.model.AuthProvider;
import dsi.sams.hostel.Auth.socialAuth.payload.ApiResponse;
import dsi.sams.hostel.Auth.socialAuth.payload.AuthResponse;
import dsi.sams.hostel.Auth.socialAuth.security.TokenProvider;
import dsi.sams.hostel.User.dto.AppUser;
import dsi.sams.hostel.User.repository.AppUserRepository;
import dsi.sams.hostel.User.security.AppUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;

@RestController
@RequestMapping("/auth")
public class AuthController {


    private AuthenticationManager authenticationManager;

    @Autowired
    private AppUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser( @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenProvider.createToken(authentication);
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser( @RequestBody RegistrationRequest signUpRequest) {
        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new BadRequestException("Email address already in use.");
        }

        // Creating user's account
        AppUser user = new AppUser();
        user.setFirstName(signUpRequest.getFirstName());
        user.setLastName(signUpRequest.getLastName());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(signUpRequest.getPassword());
        user.setAppUserRole(AppUserRole.USER);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        AppUser result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/user/me")
                .buildAndExpand(result.getId()).toUri();

        return ResponseEntity.created(location)
                .body(new ApiResponse(true, "User registered successfully@"));
    }

}