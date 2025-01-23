package com.mondol.mhmh.auth.principal;

import com.mondol.mhmh.user.repository.UserRepository;
import com.mondol.mhmh.user.schema.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public PrincipalDetail loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException(username));
        return new PrincipalDetail(user);
    }
}
