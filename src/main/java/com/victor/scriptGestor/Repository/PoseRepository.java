package com.victor.scriptGestor.Repository;

import com.victor.scriptGestor.Entity.PoseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PoseRepository extends JpaRepository<PoseEntity, Integer> {
    List<PoseEntity> findByposeName(String poseName);



}
