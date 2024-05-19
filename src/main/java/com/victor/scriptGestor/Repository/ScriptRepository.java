package com.victor.scriptGestor.Repository;

import com.victor.scriptGestor.Entity.PositionEntity;
import com.victor.scriptGestor.Entity.ScriptEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScriptRepository extends JpaRepository<ScriptEntity, Integer> {
    List<ScriptEntity> findByidGenre(int idGenre);

}
