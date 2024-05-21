package com.victor.scriptGestor.Repository;

import com.victor.scriptGestor.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    public List<UserEntity> findByemail (String email);
}
