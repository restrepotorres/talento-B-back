package com.victor.scriptGestor.Repository;

import com.victor.scriptGestor.Entity.DialogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DialogRepository extends JpaRepository<DialogEntity, Integer> {
    public List<DialogEntity> findByidPosition (int idPosition);
   // public List<DialogEntity> findByidScript (int idPosition);
    //todo find by scriptid

}
