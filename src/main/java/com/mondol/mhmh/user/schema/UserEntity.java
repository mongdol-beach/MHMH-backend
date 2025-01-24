package com.mondol.mhmh.user.schema;

import com.mondol.mhmh.auth.oAuth.LoginType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name= "account")
@Entity(name = "account")
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class UserEntity {
    @Id
    private String id; // oauth id?

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private LoginType loginType;

    @Column(nullable = true)
    private String email;
    private String picture;
    private String role = "ROLE_USER";

    public static UserEntity from(String id, String name, String email, String picture, LoginType loginType ) {
        return new UserEntity(id, name, email, picture, loginType);
    }

    private UserEntity(String id, String name, String email, String picture, LoginType loginType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.loginType = loginType;
    }

    public UserEntity update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

}