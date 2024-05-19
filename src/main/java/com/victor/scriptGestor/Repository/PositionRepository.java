package com.victor.scriptGestor.Repository;

import com.victor.scriptGestor.Entity.PoseEntity;
import com.victor.scriptGestor.Entity.PositionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PositionRepository extends JpaRepository<PositionEntity, Integer> {
 List<PositionEntity> findByidPose(int idPose);
}
