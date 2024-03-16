package com.nxm.palceup.service.impl;

import com.nxm.palceup.entities.Account;
import com.nxm.palceup.entities.Role;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;


    private String username;

    private String email;

    private String password;


    private Collection<? extends GrantedAuthority> authorities;
    public UserDetailsImpl(String username, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }
    public static UserDetailsImpl build(Account account) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        // Lấy thông tin về vai trò từ bảng Author (nếu có)
        if (account.getAuthorList() != null && !account.getAuthorList().isEmpty()) {
            // Lấy vai trò của tài khoản từ bảng Author
            Role role = account.getAuthorList().get(0).getRole();
            authorities.add(new SimpleGrantedAuthority(role.getName().name()));
        }

        // Tiếp tục thêm các quyền khác (nếu có)
        // ...

        return new UserDetailsImpl(
                account.getUsername(),
                account.getEmail(),
                account.getPassword(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
