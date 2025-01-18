package com.mondol.mhmh.user.repository;

import com.mondol.mhmh.user.schema.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AccountEntity, String> {
    Optional<AccountEntity> findByEmail(String email);
    Optional<AccountEntity> findByIdAndLoginType(String id, String type);
}
