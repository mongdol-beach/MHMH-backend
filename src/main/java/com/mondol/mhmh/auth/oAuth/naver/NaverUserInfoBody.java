package com.mondol.mhmh.auth.oAuth.naver;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NaverUserInfoBody {
    private int resultCode;
    private String message;
    private NaverResponse response;
    @Getter
    @NoArgsConstructor
    public static class NaverResponse {
        private String id; // 회원번호
        private String nickname;
        private String name;
        private String email;
        private String profile_image;
        private String gender;
        private String age;
        private String birthday;
        private String birthyear;
        private String mobile; // 휴대전화 번호
    }

    public String getId() {
        return this.response.getId();
    }

    public String getName() {
        return this.response.nickname;
    }

    public String getEmail() {
        return this.response.email;
    }

    public String getProfileUrl() {
        return this.response.profile_image;
    }
}
