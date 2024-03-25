package com.nxm.palceup.service.impl;

import com.nxm.palceup.entities.Account;
import com.nxm.palceup.repositories.AccountRepository;
import com.nxm.palceup.repositories.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final AccountRepository accountRepository;
    private final AuthorRepository authorRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account == null){
            throw  new UsernameNotFoundException("account " + username+"not found");
        }
        return UserDetailsImpl.build(account);
    }
}
