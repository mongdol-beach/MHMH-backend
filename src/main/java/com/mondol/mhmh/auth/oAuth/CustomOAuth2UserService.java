package com.mondol.mhmh.auth.oAuth;

import com.mondol.mhmh.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    private final UserRepository userRepository;

    public String a(String code){
        return code;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.print("이곳은 pouple");
        OAuth2User oauth2User = super.loadUser(userRequest);
        log.info("oAuth2User: {}", oauth2User);
        final Map<String, Object> attributes = oauth2User.getAttributes();
        final String oauthId = String.valueOf(attributes.get("id"));
        final String oauthType = userRequest.getClientRegistration().getRegistrationId();

        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_GUEST"));
        System.out.print(oauthId + "  ---  " + oauthType);
        if (userRepository.findByIdAndLoginType(oauthId, oauthType).isPresent()) {
            // 로그인 ROLE_USER
            authorities = List.of(new SimpleGrantedAuthority("ROLE_USER"));
            return new DefaultOAuth2User(authorities, oauth2User.getAttributes(), "id");
        }
        System.out.print("이곳에 옵니다");
        // ROLE_GUEST
        return new DefaultOAuth2User(authorities, oauth2User.getAttributes(), "id");
    }
}