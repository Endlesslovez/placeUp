package com.nxm.palceup.service.impl;

import com.nxm.palceup.entities.Account;
import com.nxm.palceup.entities.Author;
import com.nxm.palceup.repositories.AccountRepository;
import com.nxm.palceup.repositories.AuthorRepository;
import com.nxm.palceup.dto.LoginDTO;
import com.nxm.palceup.dto.SignUpDTO;
import com.nxm.palceup.jwt.JwtResponse;
import com.nxm.palceup.jwt.JwtTokenProvider;
import com.nxm.palceup.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    private final AuthorRepository authorRepository;
    private final UserDetailsService userDetailsService;
    @Override
    public ResponseEntity<?> registerUser(SignUpDTO signUpDTO) {
        if(accountRepository.existsAccountByUsername(signUpDTO.getUsername())){
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }
        if (accountRepository.existsAccountByEmail(signUpDTO.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Email is already in use!");
        }
        Account ac = new Account();
        ac.setUsername(signUpDTO.getUsername());
        ac.setEmail(signUpDTO.getEmail());
        ac.setPhone(signUpDTO.getPhone());
        ac.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));
        ac.setFullName(signUpDTO.getFullName());
        ac.setDate(new Date());
        ac.setStatus(1);
        accountRepository.save(ac);
        return ResponseEntity.ok("User registered successfully1");
    }

    @Override
    public ResponseEntity<?> authenticateUser(LoginDTO loginDTO) {
        String hashedPassword = passwordEncoder.encode(loginDTO.getPassword());
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenProvider.generateToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority()).collect(Collectors.toList());
        return ResponseEntity.ok(new JwtResponse(token, userDetails.getUsername(),userDetails.getEmail(),roles));

    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public List<Author> searchAllAccount(String username, String phone, String fullName, String email, Integer status, String roldeName) {
        return authorRepository.searchAllAccount(username,phone, fullName, email, status, roldeName);
    }

    @Override
    public List<Author> searchAccountNoStatus(String username, String phone, String fullName, String email, String roldeName) {
        return authorRepository.searchAccountNoStatus(username, phone, fullName, email,roldeName);
    }

    @Override
    public List<Author> searchAccountNoUsername(String phone, String fullName, String email, Integer status, String roldeName) {
        return authorRepository.searchAccountNoUsername(phone,fullName, email, status, roldeName );
    }

    @Override
    public List<Author> searchAccountNoUsernameNoStatus(String phone, String fullName, String email, String roldeName) {
        return authorRepository.searchAccountNoUsernameNoStatus(phone, fullName, email, roldeName);
    }

    @Override
    public Author searchAccountByUsername(String username) {
        return authorRepository.searchAccountByUsername(username);
    }

    @Override
    public Author getRoleByUserName(String userName) {
        return authorRepository.findByName(userName);
    }
}
