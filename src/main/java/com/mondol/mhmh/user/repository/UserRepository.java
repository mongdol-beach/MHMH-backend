package com.mondol.mhmh.user.repository;

import com.mondol.mhmh.user.schema.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByIdAndLoginType(String id, String type);
}
