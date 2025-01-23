package com.mondol.mhmh.auth.jwt;

import com.mondol.mhmh.user.repository.UserRepository;
import com.mondol.mhmh.user.schema.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.ott.InvalidOneTimeTokenException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public TokenRs refreshToken(String refreshToken) {
        if(jwtUtil.validateToken(refreshToken)) {
            String id = jwtUtil.getId(refreshToken);
            UserEntity user = userRepository.findById(id).orElseThrow();
            return TokenRs.of(
                    jwtUtil.generateAccessToken(user.getId(), user.getEmail()),
                    jwtUtil.generateRefreshToken(user.getId())
            );
        } else {
            throw new InvalidOneTimeTokenException("Invalid Refresh token");
        }
    }
}
