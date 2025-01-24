package com.mondol.mhmh.auth.principal;

import com.mondol.mhmh.user.schema.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


@AllArgsConstructor
public class PrincipalDetail implements UserDetails {
    private UserEntity user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return user.getId();
    }
    public String getEmail() {
        return user.getEmail();
    }

    public String getProfile() {
        return user.getPicture();
    }
}
