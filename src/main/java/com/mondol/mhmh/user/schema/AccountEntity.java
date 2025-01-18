package com.mondol.mhmh.user.schema;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name= "account")
@Entity(name = "account")
@NoArgsConstructor
@Getter
@AllArgsConstructor
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id; // oauth id?

    @Column(nullable = false)
    private String name;

    private String loginType;

    @Column(nullable = true)
    private String email;
    private String picture;
    private String role = "ROLE_USER";

    public AccountEntity(String name, String email, String picture) {
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public AccountEntity update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

}