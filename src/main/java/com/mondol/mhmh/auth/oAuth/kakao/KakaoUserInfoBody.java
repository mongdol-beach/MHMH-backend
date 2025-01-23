package com.mondol.mhmh.auth.oAuth.kakao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
// https://developers.kakao.com/docs/latest/ko/kakaologin/rest-api#kakaoaccount
public class KakaoUserInfoBody {
            private Long id;
            private String connected_at;
            private KakaoAccount kakao_account;

            @Getter
            @NoArgsConstructor
            public static class KakaoAccount {
                private Profile profile;
                private String email;
                private Boolean is_email_verified;
                private Boolean has_email;
                private Boolean profile_nickname_needs_agreement;
                private Boolean email_needs_agreement;
                private Boolean is_email_valid;

                @Getter
                @NoArgsConstructor
                public static class Profile {
                    private String nickname;
                    private Boolean is_default_nickname;
                    private String profile_image_url;
                    private String thumbnail_image_url;
                }
            }

    }
